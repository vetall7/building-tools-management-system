package org.example.buildingworks.entities.BuildingWork.controllers.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.buildingworks.entities.BuildingWork.controllers.api.BuildingWorkController;
import org.example.buildingworks.entities.BuildingWork.dto.GetBuildingWorkResponse;
import org.example.buildingworks.entities.BuildingWork.dto.GetBuildingWorksResponse;
import org.example.buildingworks.entities.BuildingWork.dto.PutBuildingWorkRequest;
import org.example.buildingworks.entities.BuildingWork.functions.BuildingWorkToResponseFunction;
import org.example.buildingworks.entities.BuildingWork.functions.BuildingWorksToResponseFunction;
import org.example.buildingworks.entities.BuildingWork.functions.PutBuildingWorkRequestFunction;
import org.example.buildingworks.entities.BuildingWork.services.api.BuildingWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class DefaultBuildingWorkController implements BuildingWorkController {
    private final BuildingWorkService buildingWorkService;

    private final BuildingWorksToResponseFunction buildingWorksToResponseFunction;

    private final BuildingWorkToResponseFunction buildingWorkToResponseFunction;

    private final PutBuildingWorkRequestFunction putBuildingWorkRequestFunction;

    @Autowired
    public DefaultBuildingWorkController(BuildingWorkService buildingWorkService,
                                         BuildingWorksToResponseFunction buildingWorksToResponseFunction,
                                         BuildingWorkToResponseFunction buildingWorkToResponseFunction,
                                         PutBuildingWorkRequestFunction putBuildingWorkRequestFunction){
        this.buildingWorkService = buildingWorkService;
        this.buildingWorksToResponseFunction = buildingWorksToResponseFunction;
        this.buildingWorkToResponseFunction = buildingWorkToResponseFunction;
        this.putBuildingWorkRequestFunction = putBuildingWorkRequestFunction;
    }

    @Override
    public GetBuildingWorksResponse getBuildingWorks() {
        return buildingWorksToResponseFunction.apply(buildingWorkService.findAll());
    }

    @Override
    public void createBuildingWork(UUID buildingWorkId, PutBuildingWorkRequest putBuildingWorkRequest) {
        buildingWorkService.save(putBuildingWorkRequestFunction.apply(putBuildingWorkRequest, buildingWorkId));
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

    @Override
    public GetBuildingWorkResponse getBuildingWork(UUID buildingWorkId) {
        return buildingWorkToResponseFunction.apply(buildingWorkService.findById(buildingWorkId));
    }
}