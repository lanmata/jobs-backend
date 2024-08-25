package com.prx.jobs.backend.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionApiTest {

    PositionApi positionApi = new PositionApi() {};

    @Test
    @DisplayName("It call getService method to get a new PositionService instance")
    void getServiceTest() {
        assertNotNull(positionApi.getService());
    }

}
