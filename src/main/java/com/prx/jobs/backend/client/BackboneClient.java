package com.prx.jobs.backend.client;

import com.prx.jobs.backend.api.to.AuthRequest;
import com.prx.jobs.backend.config.BackendFeignClientInterceptor;
import jakarta.ws.rs.HeaderParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import static com.prx.security.constant.ConstantApp.SESSION_TOKEN_KEY;

@FeignClient(name = "backboneClient", url = "https://prx-qa.backbone.tst/backbone", configuration = BackendFeignClientInterceptor.class)
public interface BackboneClient {

    @PostMapping("/v1/session/validate")
    boolean validate(@HeaderParam(SESSION_TOKEN_KEY) String sessionToken);

    @PostMapping("/v1/session/token")
    String token(AuthRequest authRequest);
}
