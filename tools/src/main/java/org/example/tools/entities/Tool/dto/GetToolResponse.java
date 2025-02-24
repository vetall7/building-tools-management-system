package org.example.tools.entities.Tool.dto;

import lombok.*;
import org.example.tools.entities.Tool.ToolStatus;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class GetToolResponse {
    private UUID id;

    private String name;

    private String description;

    private String imageURL;

    private ToolStatus toolStatus;
}
