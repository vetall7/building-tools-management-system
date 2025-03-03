package org.example.buildingworks.entities.BuildingWork.repositories.api;

import org.example.buildingworks.entities.BuildingWork.BuildingWork;
import org.example.buildingworks.entities.BuildingWork.Location;
import org.example.buildingworks.entities.BuildingWork.dto.LocationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BuildingWorkRepository extends JpaRepository<BuildingWork, UUID> {
    @Query("SELECT new org.example.buildingworks.entities.BuildingWork.dto.LocationDTO(bw.id, bw.location.latitude, bw.location.longitude) FROM BuildingWork bw")
    List<LocationDTO> findAllLatitudesAndLongitudes();
}
