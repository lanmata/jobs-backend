package com.prx.jobs.backend.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SourceApiTest {

    SourceApi sourceApi = new SourceApi() {};

    @Test
    @DisplayName("It call getService method to get a new ModeService instance")
    void getServiceTest() {
        assertNotNull(sourceApi.getService());
    }

}
