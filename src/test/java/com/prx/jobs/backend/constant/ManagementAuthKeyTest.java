package com.prx.jobs.backend.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagementAuthKeyTest {

    @Test
    @DisplayName("Value of GRANT_TYPE")
    void valueOfGrantType() {
        assertEquals("grant_type", ManagementAuthKey.GRANT_TYPE.value);
    }

    @Test
    @DisplayName("Value of CLIENT_ID")
    void valueOfClientId() {
        assertEquals("client_id", ManagementAuthKey.CLIENT_ID.value);
    }

    @Test
    @DisplayName("Value of USERNAME")
    void valueOfUsername() {
        assertEquals("username", ManagementAuthKey.USERNAME.value);
    }

    @Test
    @DisplayName("Value of PASSWORD")
    void valueOfPassword() {
        assertEquals("password", ManagementAuthKey.PASSWORD.value);
    }

    @Test
    @DisplayName("Value of CLIENT_SECRET")
    void valueOfClientSecret() {
        assertEquals("client_secret", ManagementAuthKey.CLIENT_SECRET.value);
    }

    @Test
    @DisplayName("Enum contains all keys")
    void enumContainsAllKeys() {
        ManagementAuthKey[] keys = ManagementAuthKey.values();
        assertEquals(5, keys.length);
        assertTrue(Arrays.asList(keys).containsAll(Arrays.asList(
            ManagementAuthKey.GRANT_TYPE,
            ManagementAuthKey.CLIENT_ID,
            ManagementAuthKey.USERNAME,
            ManagementAuthKey.PASSWORD,
            ManagementAuthKey.CLIENT_SECRET
        )));
    }
}
