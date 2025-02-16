package org.example.tools.entities.BuildingWork.services.impl;


import jakarta.persistence.EntityNotFoundException;
import org.example.tools.entities.BuildingWork.BuildingWork;
import org.example.tools.entities.BuildingWork.repositories.api.BuildingWorkRepository;
import org.example.tools.entities.BuildingWork.services.api.BuildingWorkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DefaultBuildingWorkService implements BuildingWorkService {

    private final BuildingWorkRepository buildingWorkRepository;

    @Autowired
    public DefaultBuildingWorkService(BuildingWorkRepository buildingWorkRepository) {
        this.buildingWorkRepository = buildingWorkRepository;
    }

    @Override
    public void save(BuildingWork buildingWork) {
        this.buildingWorkRepository.findById(buildingWork.getId())
                .ifPresentOrElse(
                        buildingWorkRepository::save,
                        () -> buildingWorkRepository.save(buildingWork)
                );
    }

    @Override
    public BuildingWork findById(Long id) {
        return buildingWorkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Building work with id " + id + " not found"));
    }


    @Override
    public void deleteById(Long id) {
        if (this.findById(id) != null) {
            buildingWorkRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Building work with id " + id + " not found");
        }
    }
}
