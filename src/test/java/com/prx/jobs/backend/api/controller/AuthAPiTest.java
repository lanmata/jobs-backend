package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.AuthServiceImpl;
import com.prx.jobs.backend.api.to.AuthRequest;
import com.prx.jobs.backend.api.to.AuthResponse;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.prx.jobs.backend.util.JobsConstants.BACKBONE_SESSION_TOKEN;
import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(value = {SpringExtension.class})
class AuthAPiTest {

    static String PATH;

    static {
        PATH = JOBS_PATH + "/auth";
    }

    @MockBean
    AuthServiceImpl authService;

    @InjectMocks
    AuthApiController authApiController;

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(new AuthApiController(authService));
    }

    @Test
    void getServiceTest() {
        var authAPi = new AuthAPi() {
        };
        assertNotNull(authAPi.getService());
    }

    @Test
    void accessTokenWithValidRequest() {
        AuthRequest authRequest = new AuthRequest("validUser", null);
        Map<String, Object> headers = new ConcurrentHashMap<>();
        headers.put(BACKBONE_SESSION_TOKEN, "sdfwfsf345345345");

        when(authService.validate(anyString())).thenReturn(true);
        when(authService.token(any(AuthRequest.class))).thenReturn(ResponseEntity.ok(new AuthResponse("token123")));

        given().headers(headers)
                .body(authRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().post(PATH+"/token")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    void accessTokenWithInvalidRequest() {
        AuthRequest authRequest = new AuthRequest("invalidUser", null);
        Map<String, Object> headers = new ConcurrentHashMap<>();
        headers.put(BACKBONE_SESSION_TOKEN, "sdfwfsf345345345");
        when(authService.validate(anyString())).thenReturn(true);
        when(authService.token(any(AuthRequest.class))).thenReturn(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());

        given().headers(headers)
                .body(authRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().post(PATH+"/token")
                .then().assertThat().statusCode(HttpStatus.UNAUTHORIZED.value()).expect(MvcResult::getResponse);
    }

    @Test
    void accessTokenWithMissingSessionToken() {
        AuthRequest authRequest = new AuthRequest("validUser", "validPassword");
        Map<String, Object> headers = new ConcurrentHashMap<>();
        headers.put(BACKBONE_SESSION_TOKEN, "sdfwfsf345345345");
        when(authService.validate(anyString())).thenReturn(false);

        given().headers(headers)
                .body(authRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().post(PATH+"/token")
                .then().assertThat().statusCode(HttpStatus.BAD_REQUEST.value()).expect(MvcResult::getResponse);
    }
}
