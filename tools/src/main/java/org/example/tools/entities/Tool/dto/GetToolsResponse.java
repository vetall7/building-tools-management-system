package org.example.tools.entities.Tool.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class GetToolsResponse {
    @Getter
    @Setter
    @Builder
    @ToString
    @EqualsAndHashCode
    public static class Tool {
        private UUID id;

        private String name;
    }

    private List<Tool> tools;
}
