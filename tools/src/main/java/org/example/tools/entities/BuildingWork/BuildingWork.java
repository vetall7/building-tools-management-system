package org.example.tools.entities.BuildingWork;

import jakarta.persistence.*;
import lombok.*;
import org.example.tools.entities.Tool.Tool;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

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
    private UUID id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "buildingWork", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tool> tools;
}
