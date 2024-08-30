package com.example.ArchisProject.controller;

import com.example.ArchisProject.entity.Plans;
import com.example.ArchisProject.service.PlansService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planscontroller")
@RequiredArgsConstructor
public class PlansController {

    private final PlansService plansService;

    @PostMapping
    public ResponseEntity<Plans> createPlan(@RequestBody Plans plan) {
        Plans createdPlan = plansService.createPlan(plan);
        return ResponseEntity.ok(createdPlan);
    }

    @GetMapping
    public ResponseEntity<List<Plans>> getAllPlans() {
        List<Plans> plans = plansService.getAllPlans();
        return ResponseEntity.ok(plans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plans> getPlanById(@PathVariable Long id) {
        Plans plan = plansService.getPlanById(id);
        return ResponseEntity.ok(plan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plans> updatePlan(@PathVariable Long id, @RequestBody Plans plan) {
        Plans updatedPlan = plansService.updatePlan(id, plan);
        return ResponseEntity.ok(updatedPlan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        plansService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
