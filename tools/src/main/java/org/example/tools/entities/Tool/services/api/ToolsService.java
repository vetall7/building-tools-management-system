package org.example.tools.entities.Tool.services.api;

import org.example.tools.entities.Tool.Tool;

import java.util.List;
import java.util.UUID;

public interface ToolsService {
    void save(Tool tool);

    void deleteById(UUID id);

    Tool findById(UUID id);

    List<Tool> findAll();

    List<Tool> findAllByBuildingWorkId(UUID buildingWorkId);
}
