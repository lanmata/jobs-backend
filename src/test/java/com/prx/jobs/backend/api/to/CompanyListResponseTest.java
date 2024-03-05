package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CompanyListResponseTest {

    @Test
    void shouldReturnEmptyCollectionWhenNoCompaniesProvided() {
        CompanyListResponse response = new CompanyListResponse(Collections.emptyList());

        assertTrue(response.companyTOCollection().isEmpty());
    }

    @Test
    void shouldReturnSingleCompanyWhenOneCompanyProvided() {
        CompanyTO companyTO = new CompanyTO(UUID.randomUUID(), "name", "description", false);
        CompanyListResponse response = new CompanyListResponse(List.of(companyTO));

        assertEquals(1, response.companyTOCollection().size());
        assertTrue(response.companyTOCollection().contains(companyTO));
    }

    @Test
    void shouldReturnMultipleCompaniesWhenMultipleCompaniesProvided() {
        CompanyTO companyTO1 = new CompanyTO(UUID.randomUUID(), "name", "description", false);
        CompanyTO companyTO2 = new CompanyTO(UUID.randomUUID(), "name", "description", false);
        CompanyListResponse response = new CompanyListResponse(List.of(companyTO1, companyTO2));

        assertEquals(2, response.companyTOCollection().size());
        assertTrue(response.companyTOCollection().contains(companyTO1));
        assertTrue(response.companyTOCollection().contains(companyTO2));
    }
}
