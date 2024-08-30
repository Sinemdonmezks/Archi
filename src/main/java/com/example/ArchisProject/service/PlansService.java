package com.example.ArchisProject.service;

import com.example.ArchisProject.entity.Plans;
import com.example.ArchisProject.repository.PlansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlansService {

    private final PlansRepository plansRepository;

    public Plans createPlan(Plans plan) {
        if (plan.getPlansName() == null || plan.getPlansName().isEmpty()) {
            throw new IllegalArgumentException("Plan name cannot be empty");
        }
        if (plan.getPlansDetails() == null || plan.getPlansDetails().isEmpty()) {
            throw new IllegalArgumentException("Plan details cannot be empty");
        }
        return plansRepository.save(plan);
    }

    public List<Plans> getAllPlans() {
        return plansRepository.findAll();
    }

    public Plans getPlanById(Long id) {
        Optional<Plans> plan = plansRepository.findById(id);
        if (plan.isPresent()) {
            return plan.get();
        } else {
            throw new RuntimeException("Plan not found with id: " + id);
        }
    }

    public Plans updatePlan(Long id, Plans updatedPlan) {
        Plans existingPlan = getPlanById(id);

        if (updatedPlan.getPlansName() != null && !updatedPlan.getPlansName().isEmpty()) {
            existingPlan.setPlansName(updatedPlan.getPlansName());
        }
        if (updatedPlan.getPlansDetails() != null && !updatedPlan.getPlansDetails().isEmpty()) {
            existingPlan.setPlansDetails(updatedPlan.getPlansDetails());
        }

        return plansRepository.save(existingPlan);
    }

    public void deletePlan(Long id) {
        Plans existingPlan = getPlanById(id);
        plansRepository.delete(existingPlan);
    }

}
