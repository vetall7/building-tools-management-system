package org.example.buildingworks.entities.BuildingWork.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class GetBuildingWorkResponse {
    private UUID id;

    private String name;

    private String description;

    private Double latitude;

    private Double longitude;

    private String status;
}
