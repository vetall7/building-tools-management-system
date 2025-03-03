package org.example.buildingworks.entities.BuildingWork.services.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.persistence.EntityNotFoundException;
import org.example.buildingworks.entities.BuildingWork.BuildingWork;
import org.example.buildingworks.entities.BuildingWork.Location;
import org.example.buildingworks.entities.BuildingWork.dto.LocationDTO;
import org.example.buildingworks.entities.BuildingWork.event.repository.api.BuildingWorksEventRepository;
import org.example.buildingworks.entities.BuildingWork.repositories.api.BuildingWorkRepository;
import org.example.buildingworks.entities.BuildingWork.services.api.BuildingWorkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultBuildingWorkService implements BuildingWorkService {

    private final BuildingWorkRepository buildingWorkRepository;

    private final BuildingWorksEventRepository buildingWorksEventRepository;

    @Autowired
    public DefaultBuildingWorkService(BuildingWorkRepository buildingWorkRepository, BuildingWorksEventRepository buildingWorksEventRepository) {
        this.buildingWorkRepository = buildingWorkRepository;
        this.buildingWorksEventRepository = buildingWorksEventRepository;
    }

    @Override
    public List<BuildingWork> findAll() {
        return buildingWorkRepository.findAll();
    }

    @Override
    public BuildingWork findById(UUID id) {
        return buildingWorkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Building work with id " + id + " not found"));
    }

    @Override
    public void save(BuildingWork buildingWork) {
        this.buildingWorkRepository.findById(buildingWork.getId())
                .ifPresentOrElse(
                        (existingBuildingWork) -> {
                            BeanUtils.copyProperties(buildingWork, existingBuildingWork);
                            buildingWorkRepository.save(existingBuildingWork);
                        },
                        () -> {
                            buildingWorkRepository.save(buildingWork);
                            buildingWorksEventRepository.save(buildingWork.getId());
                        }
                );
    }

    @Override
    public void deleteById(UUID id) {
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

    @Override
    public List<LocationDTO> findAllLatitudesAndLongitudes() {
        return buildingWorkRepository.findAllLatitudesAndLongitudes();
    }
}
