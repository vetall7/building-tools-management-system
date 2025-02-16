package org.example.tools.entities.Tool.controllers.api;

import org.example.tools.entities.Tool.dto.GetToolResponse;
import org.example.tools.entities.Tool.dto.GetToolsResponse;
import org.example.tools.entities.Tool.dto.PutToolRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface ToolsController {
    @GetMapping("/api/tools")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetToolsResponse getTools();

    @GetMapping("/api/tools/{toolId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetToolResponse getTool(
            Long toolId
    );

    @PutMapping("/api/tools/{toolId}")
    @ResponseStatus(HttpStatus.CREATED)
    void createTool(
            Long toolId,
            PutToolRequest putToolRequest
    );

    @DeleteMapping("/api/tools/{toolId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTool(
            Long toolId
    );
}
