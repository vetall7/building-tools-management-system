package org.example.buildingworks.entities.BuildingWork.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.buildingworks.entities.BuildingWork.BuildingWork;
import org.example.buildingworks.entities.BuildingWork.repositories.api.BuildingWorkRepository;
import org.example.buildingworks.entities.BuildingWork.services.api.BuildingWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBuildingWorkService implements BuildingWorkService {

    private final BuildingWorkRepository buildingWorkRepository;

    @Autowired
    public DefaultBuildingWorkService(BuildingWorkRepository buildingWorkRepository) {
        this.buildingWorkRepository = buildingWorkRepository;
    }

    @Override
    public List<BuildingWork> findAll() {
        return buildingWorkRepository.findAll();
    }

    @Override
    public BuildingWork findById(Long id) {
        return buildingWorkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Building work with id " + id + " not found"));
    }

    @Override
    public void save(BuildingWork buildingWork) {
        buildingWorkRepository.save(buildingWork);
    }

    @Override
    public void deleteById(Long id) {
        if (this.findById(id) != null) {
            buildingWorkRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Building work with id " + id + " not found");
        }
    }

    @Override
    public void update(BuildingWork buildingWork) {
        buildingWorkRepository.save(buildingWork);
    }
}
