package org.example.tools.entities.Tool.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.tools.entities.Tool.Tool;
import org.example.tools.entities.Tool.repositories.api.ToolsRepository;
import org.example.tools.entities.Tool.services.api.ToolsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultToolsService implements ToolsService {
    private final ToolsRepository toolsRepository;

    public DefaultToolsService(ToolsRepository toolsRepository) {
        this.toolsRepository = toolsRepository;
    }

    @Override
    public List<Tool> findAll() {
        return toolsRepository.findAll();
    }

    @Override
    public Tool findById(Long id) {
        return toolsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tool with id " + id + " not found"));
    }

    @Override
    public void save(Tool tool) {
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
    public void deleteById(Long id) {
        this.toolsRepository.findById(id)
                .ifPresentOrElse(
                        (tool) -> toolsRepository.deleteById(id),
                        () -> {
                            throw new EntityNotFoundException("Tool with id " + id + " not found");
                        }
                );
    }
}
