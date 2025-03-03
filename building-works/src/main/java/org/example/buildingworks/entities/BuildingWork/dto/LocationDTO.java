package org.example.buildingworks.entities.BuildingWork.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    private UUID id;

    private Double latitude;

    private Double longitude;
}
