package org.example.tools.entities.BuildingWork.services.api;

import org.example.tools.entities.BuildingWork.BuildingWork;

public interface BuildingWorkService {
    void save(BuildingWork buildingWork);

    void deleteById(Long id);

    BuildingWork findById(Long id);
}
