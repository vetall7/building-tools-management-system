package org.example.tools.entities.BuildingWork.controllers.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.tools.entities.BuildingWork.controllers.api.BuildingWorkController;
import org.example.tools.entities.BuildingWork.functions.PutBuildingWorkRequestFunction;
import org.example.tools.entities.BuildingWork.services.api.BuildingWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class DefaultBuildingWorkController implements BuildingWorkController {
    private final BuildingWorkService buildingWorkService;

    private final PutBuildingWorkRequestFunction putBuildingWorkRequestFunction;

    @Autowired
    public DefaultBuildingWorkController(BuildingWorkService buildingWorkService,
                                         PutBuildingWorkRequestFunction putBuildingWorkRequestFunction){
        this.buildingWorkService = buildingWorkService;
        this.putBuildingWorkRequestFunction = putBuildingWorkRequestFunction;
    }

    @Override
    public void createBuildingWork(UUID buildingWorkId) {
        buildingWorkService.save(putBuildingWorkRequestFunction.apply(buildingWorkId));
    }

    @Override
    public void deleteBuildingWork(UUID buildingWorkId) {
        try {
            buildingWorkService.deleteById(buildingWorkId);
        }
        catch (EntityNotFoundException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}