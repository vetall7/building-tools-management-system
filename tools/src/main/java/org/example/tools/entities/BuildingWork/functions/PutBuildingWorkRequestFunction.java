package org.example.tools.entities.BuildingWork.functions;


import org.example.tools.entities.BuildingWork.BuildingWork;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PutBuildingWorkRequestFunction implements Function<Long, BuildingWork> {
    @Override
    public BuildingWork apply(Long id) {
        return BuildingWork.builder()
                .id(id)
                .build();
    }
}
