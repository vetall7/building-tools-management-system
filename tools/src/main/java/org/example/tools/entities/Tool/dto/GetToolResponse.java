package org.example.tools.entities.Tool.dto;

import lombok.*;
import org.example.tools.entities.Tool.ToolStatus;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class GetToolResponse {
    private Long id;

    private String name;

    private String description;

    private String imageURL;

    private ToolStatus toolStatus;
}
