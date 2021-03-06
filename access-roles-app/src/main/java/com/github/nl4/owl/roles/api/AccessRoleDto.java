package com.github.nl4.owl.roles.api;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class AccessRoleDto {

    private UUID id;
    private UUID personId;
    private LocationDto location;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private String createdBy;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}