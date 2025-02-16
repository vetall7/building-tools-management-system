package org.example.tools.entities.Tool.dto;

import lombok.*;

import java.util.List;

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
        private Long id;

        private String name;
    }

    private List<Tool> tools;
}
