package org.example.tools.entities.BuildingWork.functions;


import org.example.tools.entities.BuildingWork.BuildingWork;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class PutBuildingWorkRequestFunction implements Function<UUID, BuildingWork> {
    @Override
    public BuildingWork apply(UUID id) {
        return BuildingWork.builder()
                .id(id)
                .build();
    }
}
