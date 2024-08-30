package com.example.ArchisProject.utils;

import com.example.ArchisProject.entity.Plans;
import com.example.ArchisProject.repository.PlansRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanDataLoader {

    @Autowired
    private PlansRepository plansRepository;

    @PostConstruct
    public void loadData() throws Exception {
        if (plansRepository.count() == 0) {
            Plans plan1 = new Plans(null, "Plan A", "Details of Plan A");
            Plans plan2 = new Plans(null, "Plan B", "Details of Plan B");
            Plans plan3 = new Plans(null, "Plan C", "Details of Plan C");

            plansRepository.save(plan1);
            plansRepository.save(plan2);
            plansRepository.save(plan3);

        } else
            throw new Exception("Plans could not be added");
    }
}

