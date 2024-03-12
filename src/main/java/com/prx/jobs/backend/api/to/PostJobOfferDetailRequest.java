package com.prx.jobs.backend.api.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PostJobOfferDetailRequest(@NotNull @NotBlank String description,
                                        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @NotNull LocalDateTime datetime,
                                        @NotNull BigDecimal mountRate,
                                        @NotNull UUID statusId){

}
