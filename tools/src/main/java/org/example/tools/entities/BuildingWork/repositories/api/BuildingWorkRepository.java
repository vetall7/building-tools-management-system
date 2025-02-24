package org.example.tools.entities.BuildingWork.repositories.api;


import org.example.tools.entities.BuildingWork.BuildingWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuildingWorkRepository extends JpaRepository<BuildingWork, UUID> {
}
