package org.example.tools.entities.BuildingWork.services.api;

import org.example.tools.entities.BuildingWork.BuildingWork;

import java.util.UUID;

public interface BuildingWorkService {
    void save(BuildingWork buildingWork);

    void deleteById(UUID id);

    BuildingWork findById(UUID id);
}
