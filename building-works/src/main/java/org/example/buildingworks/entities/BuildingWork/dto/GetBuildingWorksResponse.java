package org.example.buildingworks.entities.BuildingWork.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class GetBuildingWorksResponse {

    @Getter
    @Setter
    @Builder
    @ToString
    @EqualsAndHashCode
    public static class BuildingWork {
        private UUID id;

        private String name;
    }

    @Singular
    private List<BuildingWork> buildingWorks;
}
