package org.example.buildingworks.entities.BuildingWork.event.repository.impl;

import org.example.buildingworks.entities.BuildingWork.event.repository.api.BuildingWorksEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class BuildingWorkEventRepositoryDefault implements BuildingWorksEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public BuildingWorkEventRepositoryDefault(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void save(UUID buildingWorkId) {
        this.restTemplate.put("/api/building-works/{buildingWorkId}", null, buildingWorkId);
    }

    @Override
    public void delete(UUID buildingWorkId) {
        this.restTemplate.delete("/api/building-works/{buildingWorkId}", buildingWorkId);
    }
}
