package org.example.tools.entities.Tool;

import jakarta.persistence.*;
import lombok.*;
import org.example.tools.entities.BuildingWork.BuildingWork;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "tools")
public class Tool implements Serializable {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private String imageURL;

    private ToolStatus toolStatus;

    @ManyToOne()
    @JoinColumn(name = "building_work_id")
    private BuildingWork buildingWork;
}
