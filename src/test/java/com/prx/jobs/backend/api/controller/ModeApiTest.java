package com.prx.jobs.backend.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModeApiTest {

    ModeApi modeApi = new ModeApi() {};

    @Test
    @DisplayName("It call getService method to get a new ModeService instance")
    void getServiceTest() {
        assertNotNull(modeApi.getService());
    }

}
