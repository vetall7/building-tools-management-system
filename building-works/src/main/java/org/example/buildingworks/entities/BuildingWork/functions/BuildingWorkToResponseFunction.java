package org.example.buildingworks.entities.BuildingWork.functions;

import org.example.buildingworks.entities.BuildingWork.BuildingWork;
import org.example.buildingworks.entities.BuildingWork.dto.GetBuildingWorkResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BuildingWorkToResponseFunction implements Function<BuildingWork, GetBuildingWorkResponse> {
    @Override
    public GetBuildingWorkResponse apply(BuildingWork buildingWork) {
        return GetBuildingWorkResponse.builder()
                .id(buildingWork.getId())
                .name(buildingWork.getName())
                .description(buildingWork.getDescription())
                .latitude(buildingWork.getLocation().getLatitude())
                .longitude(buildingWork.getLocation().getLongitude())
                .status(buildingWork.getStatus())
                .build();
    }
}
