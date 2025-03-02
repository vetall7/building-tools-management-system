package org.example.tools.entities.Tool.functions;

import org.example.tools.entities.Tool.Tool;
import org.example.tools.entities.Tool.dto.GetToolResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ToolToResponseFunction implements Function<Tool, GetToolResponse> {
    @Override
    public GetToolResponse apply(Tool tool) {
        return GetToolResponse.builder()
                .id(tool.getId())
                .name(tool.getName())
                .description(tool.getDescription())
                .imageURL(tool.getImageURL())
                .toolStatus(tool.getToolStatus())
                .build();
    }
}
