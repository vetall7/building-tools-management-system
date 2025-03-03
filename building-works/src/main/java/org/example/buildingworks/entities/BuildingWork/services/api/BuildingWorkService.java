package org.example.buildingworks.entities.BuildingWork.services.api;

import org.example.buildingworks.entities.BuildingWork.BuildingWork;
import org.example.buildingworks.entities.BuildingWork.dto.LocationDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BuildingWorkService {
    BuildingWork findById(UUID id);

    void save(BuildingWork buildingWork);

    void deleteById(UUID id);

    List<BuildingWork> findAll();

    void update(BuildingWork buildingWork);

    List<LocationDTO> findAllLatitudesAndLongitudes();
}
