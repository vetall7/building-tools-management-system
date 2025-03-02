package org.example.tools.entities.Tool.functions;

import org.example.tools.entities.Tool.Tool;
import org.example.tools.entities.Tool.dto.GetToolsResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class ToolsToResponseFunction implements Function<List<Tool>, GetToolsResponse> {
    @Override
    public GetToolsResponse apply(List<Tool> tools) {
        return GetToolsResponse.builder()
                .tools(tools.stream().map(tool -> GetToolsResponse.Tool.builder()
                        .id(tool.getId())
                        .name(tool.getName())
                        .build())
                        .toList())
                .build();
    }
}
