package org.example.buildingworks.entities.BuildingWork.functions;

import org.example.buildingworks.entities.BuildingWork.BuildingWork;
import org.example.buildingworks.entities.BuildingWork.dto.PutBuildingWorkRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class PutBuildingWorkRequestFunction implements BiFunction<PutBuildingWorkRequest, UUID, BuildingWork> {
    @Override
    public BuildingWork apply(PutBuildingWorkRequest putBuildingWorkRequest, UUID id) {
        return BuildingWork.builder()
                .id(id)
                .name(putBuildingWorkRequest.getName())
                .description(putBuildingWorkRequest.getDescription())
                .location(putBuildingWorkRequest.getLocation())
                .status(putBuildingWorkRequest.getStatus())
                .build();
    }
}
