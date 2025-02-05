package org.example.buildingworks.entities.BuildingWork.repositories.api;

import org.example.buildingworks.entities.BuildingWork.BuildingWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingWorkRepository extends JpaRepository<BuildingWork, Long> {
}
