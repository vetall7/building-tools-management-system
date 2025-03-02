package org.example.tools.entities.Tool.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.tools.entities.BuildingWork.BuildingWork;
import org.example.tools.entities.BuildingWork.repositories.api.BuildingWorkRepository;
import org.example.tools.entities.Tool.Tool;
import org.example.tools.entities.Tool.repositories.api.ToolsRepository;
import org.example.tools.entities.Tool.services.api.ToolsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultToolsService implements ToolsService {
    private final ToolsRepository toolsRepository;

    private final BuildingWorkRepository buildingWorkRepository;

    @Autowired
    public DefaultToolsService(ToolsRepository toolsRepository, BuildingWorkRepository buildingWorkRepository) {
        this.toolsRepository = toolsRepository;
        this.buildingWorkRepository = buildingWorkRepository;
    }

    @Override
    public List<Tool> findAll() {
        return toolsRepository.findAll();
    }

    @Override
    public Tool findById(UUID id) {
        return toolsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tool with id " + id + " not found"));
    }

    @Override
    public void save(Tool tool) {

        BuildingWork buildingWork = tool.getBuildingWork();

        this.buildingWorkRepository.findById(buildingWork.getId())
                .orElseThrow(() -> new EntityNotFoundException("BuildingWork with id " + buildingWork.getId() + " not found"));

        this.toolsRepository.findById(tool.getId())
                .ifPresentOrElse(
                        (existingTool) -> {
                            BeanUtils.copyProperties(tool, existingTool);
                            toolsRepository.save(existingTool);
                        },
                        () -> toolsRepository.save(tool)
                );
    }

    @Override
    public void deleteById(UUID id) {
        this.toolsRepository.findById(id)
                .ifPresentOrElse(
                        (tool) -> toolsRepository.deleteById(id),
                        () -> {
                            throw new EntityNotFoundException("Tool with id " + id + " not found");
                        }
                );
    }

    @Override
    public List<Tool> findAllByBuildingWorkId(UUID buildingWorkId) {
        this.buildingWorkRepository.findById(buildingWorkId)
                .orElseThrow(() -> new EntityNotFoundException("BuildingWork with id " + buildingWorkId + " not found"));

        return toolsRepository.findAllByBuildingWorkId(buildingWorkId);
    }
}
