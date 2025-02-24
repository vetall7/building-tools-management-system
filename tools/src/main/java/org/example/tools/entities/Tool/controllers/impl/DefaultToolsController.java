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

import java.util.UUID;

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
    public GetToolResponse getTool(UUID toolId) {
        try {
            return toolToResponseFunction.apply(toolsService.findById(toolId));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void createTool(UUID toolId, PutToolRequest putToolRequest) {
        System.out.println(putToolRequest.toString());
        try {
            toolsService.save(putToolFunction.apply(putToolRequest, toolId));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTool(UUID toolId) {
        try {
            toolsService.deleteById(toolId);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
