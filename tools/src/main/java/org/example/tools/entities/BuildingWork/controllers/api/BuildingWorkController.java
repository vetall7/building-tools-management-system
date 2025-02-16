package org.example.tools.entities.BuildingWork.controllers.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface BuildingWorkController {
    @PutMapping("/api/building-works/{buildingWorkId}")
    @ResponseStatus(HttpStatus.CREATED)
    void createBuildingWork(
            @PathVariable
            Long buildingWorkId
    );

    @DeleteMapping("/api/building-works/{buildingWorkId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBuildingWork(
            @PathVariable
            Long buildingWorkId
    );
}
