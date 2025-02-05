package org.example.buildingworks.entities.BuildingWork.dto;

import lombok.*;

import java.util.List;

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
        private Long id;

        private String name;
    }

    @Singular
    private List<BuildingWork> buildingWorks;
}
