package org.example.tools.entities.BuildingWork.controllers.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface BuildingWorkController {
    @PutMapping("/api/building-works/{buildingWorkId}")
    @ResponseStatus(HttpStatus.CREATED)
    void createBuildingWork(
            @PathVariable
            UUID buildingWorkId
    );

    @DeleteMapping("/api/building-works/{buildingWorkId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBuildingWork(
            @PathVariable
            UUID buildingWorkId
    );
}
