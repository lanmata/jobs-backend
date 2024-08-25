package com.prx.jobs.backend.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JobOfferDetailApiTest {

    JobOfferDetailApi jobOfferDetailApi = new JobOfferDetailApi() {};

    @Test
    @DisplayName("It call getService method to get a new JobOfferDetailService instance")
    void getServiceTest() {
        assertNotNull(jobOfferDetailApi.getService());
    }

}
