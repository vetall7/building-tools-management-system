package org.example.tools.entities.Tool.services.api;

import org.example.tools.entities.Tool.Tool;

import java.util.List;

public interface ToolsService {
    void save(Tool tool);

    void deleteById(Long id);

    Tool findById(Long id);

    List<Tool> findAll();
}
