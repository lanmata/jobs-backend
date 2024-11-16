package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AuthRequestTest {

    @Test
    @DisplayName("Should initialize with default constructor")
    void shouldInitializeWithDefaultConstructor() {
        AuthRequest authRequest = new AuthRequest();
        assertNull(authRequest.getAlias());
        assertNull(authRequest.getPassword());
    }

    @Test
    @DisplayName("Should initialize with parameterized constructor")
    void shouldInitializeWithParameterizedConstructor() {
        AuthRequest authRequest = new AuthRequest("userAlias", "userPassword");
        assertEquals("userAlias", authRequest.getAlias());
        assertEquals("userPassword", authRequest.getPassword());
    }

    @Test
    @DisplayName("Should set alias")
    void shouldSetAlias() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAlias("newAlias");
        assertEquals("newAlias", authRequest.getAlias());
    }

    @Test
    @DisplayName("Should set password")
    void shouldSetPassword() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setPassword("newPassword");
        assertEquals("newPassword", authRequest.getPassword());
    }

    @Test
    @DisplayName("Should handle null alias")
    void shouldHandleNullAlias() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setAlias(null);
        assertNull(authRequest.getAlias());
    }

    @Test
    @DisplayName("Should handle null password")
    void shouldHandleNullPassword() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setPassword(null);
        assertNull(authRequest.getPassword());
    }
}
