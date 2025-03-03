package org.example.buildingworks.entities.BuildingWork;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.springframework.stereotype.Service;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    private Double latitude;

    private Double longitude;
}
