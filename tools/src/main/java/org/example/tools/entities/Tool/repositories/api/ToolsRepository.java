package org.example.tools.entities.Tool.repositories.api;

import org.example.tools.entities.Tool.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ToolsRepository extends JpaRepository<Tool, UUID> {
    List<Tool> findAllByBuildingWorkId(UUID buildingWorkId);
}
