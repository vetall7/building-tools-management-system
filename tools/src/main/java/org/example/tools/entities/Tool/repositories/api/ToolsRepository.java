package org.example.tools.entities.Tool.repositories.api;

import org.example.tools.entities.Tool.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolsRepository extends JpaRepository<Tool, Long> {
}
