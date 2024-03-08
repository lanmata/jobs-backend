package com.prx.jobs.backend.api.to;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record GetPostResponse(UUID id, String title, String description,
                              String reference, UUID companyId, String company,
                              UUID positionId, String position, UUID termId, String term,
                              UUID modeId, String mode, UUID sourceId, String source,
                              List<PostDetailTO> postDetailList) {
    public GetPostResponse {
        if (postDetailList == null) {
            postDetailList = new ArrayList<>();
        }
    }
}
