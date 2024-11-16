package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TokenResponseTest {

    @Test
    @DisplayName("Should initialize with default constructor")
    void shouldInitializeWithDefaultConstructor() {
        TokenResponse tokenResponse = new TokenResponse();
        assertNull(tokenResponse.getAccessToken());
        assertEquals(0, tokenResponse.getExpiresIn());
        assertEquals(0, tokenResponse.getRefreshExpiresIn());
        assertNull(tokenResponse.getRefreshToken());
        assertNull(tokenResponse.getTokenType());
        assertEquals(0, tokenResponse.getNotBeforePolicy());
        assertNull(tokenResponse.getSessionState());
        assertNull(tokenResponse.getScope());
    }

    @Test
    @DisplayName("Should set and get access token")
    void shouldSetAndGetAccessToken() {
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken("accessToken");
        assertEquals("accessToken", tokenResponse.getAccessToken());
    }

    @Test
    @DisplayName("Should set and get expires in")
    void shouldSetAndGetExpiresIn() {
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setExpiresIn(3600);
        assertEquals(3600, tokenResponse.getExpiresIn());
    }

    @Test
    @DisplayName("Should set and get refresh expires in")
    void shouldSetAndGetRefreshExpiresIn() {
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setRefreshExpiresIn(7200);
        assertEquals(7200, tokenResponse.getRefreshExpiresIn());
    }

    @Test
    @DisplayName("Should set and get refresh token")
    void shouldSetAndGetRefreshToken() {
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setRefreshToken("refreshToken");
        assertEquals("refreshToken", tokenResponse.getRefreshToken());
    }

    @Test
    @DisplayName("Should set and get token type")
    void shouldSetAndGetTokenType() {
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setTokenType("Bearer");
        assertEquals("Bearer", tokenResponse.getTokenType());
    }

    @Test
    @DisplayName("Should set and get not before policy")
    void shouldSetAndGetNotBeforePolicy() {
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setNotBeforePolicy(0);
        assertEquals(0, tokenResponse.getNotBeforePolicy());
    }

    @Test
    @DisplayName("Should set and get session state")
    void shouldSetAndGetSessionState() {
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setSessionState("sessionState");
        assertEquals("sessionState", tokenResponse.getSessionState());
    }

    @Test
    @DisplayName("Should set and get scope")
    void shouldSetAndGetScope() {
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setScope("scope");
        assertEquals("scope", tokenResponse.getScope());
    }
}
