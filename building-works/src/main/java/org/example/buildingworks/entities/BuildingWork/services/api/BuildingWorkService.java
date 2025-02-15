package org.example.buildingworks.entities.BuildingWork.services.api;

import org.example.buildingworks.entities.BuildingWork.BuildingWork;

import java.util.List;
import java.util.Optional;

public interface BuildingWorkService {
    BuildingWork findById(Long id);

    void save(BuildingWork buildingWork);

    void deleteById(Long id);

    List<BuildingWork> findAll();

    void update(BuildingWork buildingWork);
}
