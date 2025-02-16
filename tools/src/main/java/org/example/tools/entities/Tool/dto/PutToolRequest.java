package org.example.tools.entities.Tool.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class PutToolRequest {
    private String name;

    private String description;

    private String imageURL;

    private String toolStatus;

    private Long buildingWorkId;
}
