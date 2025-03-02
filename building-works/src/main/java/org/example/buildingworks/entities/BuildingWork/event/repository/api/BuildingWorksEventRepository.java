package org.example.buildingworks.entities.BuildingWork.event.repository.api;

import java.util.UUID;

public interface BuildingWorksEventRepository {
    void save(UUID buildingWorkId);

    void delete(UUID buildingWorkId);
}
