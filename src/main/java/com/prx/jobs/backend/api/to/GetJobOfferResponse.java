package com.prx.jobs.backend.api.to;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This is the GetJobOfferResponse class.
 * It provides methods for managing job offer records.
 */
public record GetJobOfferResponse(UUID id, String title, String description,
                                  String reference, UUID companyId, String company,
                                  UUID positionId, String position, UUID termId, String term,
                                  UUID modeId, String mode, UUID sourceId, String source,
                                  List<JobOfferDetailTO> postDetailList) {

    /**
     * Default constructor.
     */
    public GetJobOfferResponse {
        if (postDetailList == null) {
            postDetailList = new ArrayList<>();
        }
    }
}
