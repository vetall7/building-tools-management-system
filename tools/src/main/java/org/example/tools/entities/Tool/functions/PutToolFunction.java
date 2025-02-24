package org.example.tools.entities.Tool.functions;

import org.example.tools.entities.BuildingWork.BuildingWork;
import org.example.tools.entities.Tool.Tool;
import org.example.tools.entities.Tool.ToolStatus;
import org.example.tools.entities.Tool.dto.PutToolRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class PutToolFunction implements BiFunction<PutToolRequest, UUID, Tool> {
    @Override
    public Tool apply(PutToolRequest putToolRequest, UUID id) {
        return Tool.builder()
                .id(id)
                .name(putToolRequest.getName())
                .description(putToolRequest.getDescription())
                .imageURL(putToolRequest.getImageURL())
                .toolStatus(ToolStatus.valueOf(putToolRequest.getToolStatus()))
                .buildingWork(BuildingWork.builder().id(putToolRequest.getBuildingWorkId()).build())
                .build();
    }
}
