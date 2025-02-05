package org.example.buildingworks.entities.BuildingWork.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class PutBuildingWorkRequest {
    private String name;

    private String description;

    private String location;

    private String status;
}
