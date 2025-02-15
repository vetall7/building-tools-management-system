package org.example.buildingworks.entities.BuildingWork;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "building_works")
public class BuildingWork implements Serializable {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String location;

    private String status;

    @Version
    private Long version = 0L;
}



