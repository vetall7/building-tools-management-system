package org.example.buildingworks.entities.BuildingWork.controllers.api;

import org.example.buildingworks.entities.BuildingWork.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.example.buildingworks.entities.BuildingWork.Location;

import java.util.List;
import java.util.UUID;


public interface BuildingWorkController {
    @GetMapping("/api/building-works")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBuildingWorksResponse getBuildingWorks();

    @GetMapping("/api/building-works/{buildingWorkId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBuildingWorkResponse getBuildingWork(
            @PathVariable
            UUID buildingWorkId
    );

    @PutMapping("/api/building-works/{buildingWorkId}")
    @ResponseStatus(HttpStatus.CREATED)
    void createBuildingWork(
            @PathVariable
            UUID buildingWorkId,
            @RequestBody
            PutBuildingWorkRequest
            putBuildingWorkRequest
    );

//    @PatchMapping("/api/building-works/{buildingWorkId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    void updateBuildingWork(
//            @PathVariable
//            UUID buildingWorkId,
//            @RequestBody
//            PatchBuildingWorkRequest
//            fieldsToUpdate
//    );

    @DeleteMapping("/api/building-works/{buildingWorkId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBuildingWork(
            @PathVariable
            UUID buildingWorkId
    );

    @GetMapping("/api/building-works/locations")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<LocationDTO> getBuildingWorksLocations();
}
