package com.srilakshmigoldbuyers.controller;


import com.srilakshmigoldbuyers.model.GoldRate;
import com.srilakshmigoldbuyers.service.GoldRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gold-rates")
@CrossOrigin(origins = "*")
public class GoldRateController {

    private final GoldRateService goldRateService;

    // Constructor
    public GoldRateController(GoldRateService goldRateService) {
        this.goldRateService = goldRateService;
    }

    // Get all gold rates
    @GetMapping
    public ResponseEntity<List<GoldRate>> getAllGoldRates() {

        return ResponseEntity.ok(
                goldRateService.getAllGoldRates()
        );
    }

    // Get gold rate by ID
    @GetMapping("/{id}")
    public ResponseEntity<GoldRate> getGoldRateById(
            @PathVariable Long id) {

        return goldRateService.getGoldRateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create gold rate
    @PostMapping
    public ResponseEntity<GoldRate> createGoldRate(
            @RequestBody GoldRate goldRate) {

        return ResponseEntity.ok(
                goldRateService.createGoldRate(goldRate)
        );
    }

    // Update gold rate
    @PutMapping("/{id}")
    public ResponseEntity<GoldRate> updateGoldRate(
            @PathVariable Long id,
            @RequestBody GoldRate goldRate) {

        GoldRate updatedGoldRate =
                GoldRateService.updateGoldRate(id, goldRate);

        if (updatedGoldRate == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedGoldRate);
    }

    // Delete gold rate
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoldRate(
            @PathVariable Long id) {

        goldRateService.deleteGoldRate(id);

        return ResponseEntity.noContent().build();
    }
}
