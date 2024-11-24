package com.prx.jobs.backend.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthKeyTest {

    @Test
    @DisplayName("Value of SESSION_ID")
    void valueOfSessionId() {
        assertEquals("sessionId", AuthKey.SESSION_ID.value);
    }

    @Test
    @DisplayName("Value of USERNAME")
    void valueOfUsername() {
        assertEquals("username", AuthKey.USERNAME.value);
    }

    @Test
    @DisplayName("Value of TYPE")
    void valueOfType() {
        assertEquals("type", AuthKey.TYPE.value);
    }

    @Test
    @DisplayName("Value of IAT")
    void valueOfIat() {
        assertEquals("iat", AuthKey.IAT.value);
    }

    @Test
    @DisplayName("Value of JTI")
    void valueOfJti() {
        assertEquals("jti", AuthKey.JTI.value);
    }

    @Test
    @DisplayName("Enum contains all keys")
    void enumContainsAllKeys() {
        AuthKey[] keys = AuthKey.values();
        assertEquals(5, keys.length);
        assertTrue(Arrays.asList(keys).containsAll(Arrays.asList(
            AuthKey.SESSION_ID,
            AuthKey.USERNAME,
            AuthKey.TYPE,
            AuthKey.IAT,
            AuthKey.JTI
        )));
    }
}
