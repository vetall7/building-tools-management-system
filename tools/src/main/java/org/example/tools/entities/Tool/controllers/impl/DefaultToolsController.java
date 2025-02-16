package org.example.tools.entities.Tool.controllers.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.tools.entities.Tool.controllers.api.ToolsController;
import org.example.tools.entities.Tool.dto.GetToolResponse;
import org.example.tools.entities.Tool.dto.GetToolsResponse;
import org.example.tools.entities.Tool.dto.PutToolRequest;
import org.example.tools.entities.Tool.functions.PutToolFunction;
import org.example.tools.entities.Tool.functions.ToolToResponseFunction;
import org.example.tools.entities.Tool.functions.ToolsToResponseFunction;
import org.example.tools.entities.Tool.services.api.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DefaultToolsController implements ToolsController {
    private final ToolsService toolsService;

    private final ToolsToResponseFunction toolsToResponseFunction;

    private final ToolToResponseFunction toolToResponseFunction;

    private final PutToolFunction putToolFunction;

    @Autowired
    public DefaultToolsController(ToolsService toolsService, ToolsToResponseFunction toolsToResponseFunction, PutToolFunction putToolFunction, ToolToResponseFunction toolToResponseFunction) {
        this.toolsService = toolsService;
        this.toolsToResponseFunction = toolsToResponseFunction;
        this.toolToResponseFunction = toolToResponseFunction;
        this.putToolFunction = putToolFunction;
    }

    @Override
    public GetToolsResponse getTools() {
        return toolsToResponseFunction.apply(toolsService.findAll());
    }

    @Override
    public GetToolResponse getTool(Long toolId) {
        try {
            return toolToResponseFunction.apply(toolsService.findById(toolId));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void createTool(Long toolId, PutToolRequest putToolRequest) {
        toolsService.save(putToolFunction.apply(putToolRequest, toolId));
    }

    @Override
    public void deleteTool(Long toolId) {
        try {
            toolsService.deleteById(toolId);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
