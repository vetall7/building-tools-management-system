package org.example.buildingworks.entities.BuildingWork.functions;

import org.example.buildingworks.entities.BuildingWork.BuildingWork;
import org.example.buildingworks.entities.BuildingWork.dto.GetBuildingWorksResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class BuildingWorksToResponseFunction implements Function<List<BuildingWork>, GetBuildingWorksResponse> {
    @Override
    public GetBuildingWorksResponse apply(List<BuildingWork> buildingWorks) {
        return GetBuildingWorksResponse.builder()
                .buildingWorks(buildingWorks.stream()
                        .map(
                                buildingWork -> GetBuildingWorksResponse.BuildingWork.builder()
                                        .id(buildingWork.getId())
                                        .name(buildingWork.getName())
                                        .build()
                        ).toList())
                .build();
    }
}
