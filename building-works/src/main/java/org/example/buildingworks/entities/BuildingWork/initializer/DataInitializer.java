package org.example.buildingworks.entities.BuildingWork.initializer;


import org.example.buildingworks.entities.BuildingWork.BuildingWork;
import org.example.buildingworks.entities.BuildingWork.services.api.BuildingWorkService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements InitializingBean {
    private final BuildingWorkService buildingWorkService;

    @Autowired
    public DataInitializer(BuildingWorkService buildingWorkService) {
        this.buildingWorkService = buildingWorkService;
    }

    @Override
    public void afterPropertiesSet() {


    }

}
