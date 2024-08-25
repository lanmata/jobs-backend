package com.prx.jobs.backend.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class JobOfferApiTest {

    JobOfferApi jobOfferApi = new JobOfferApi() {};

    @Test
    @DisplayName("It call getService method to get a new JobOfferService instance")
    void getServiceTest() {
        assertNotNull(jobOfferApi.getService());
    }

}
