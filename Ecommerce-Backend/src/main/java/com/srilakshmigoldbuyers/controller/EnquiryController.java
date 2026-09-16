package com.srilakshmigoldbuyers.controller;

import com.srilakshmigoldbuyers.model.Enquiry;
import com.srilakshmigoldbuyers.service.EnquiryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin(origins = "*")
public class EnquiryController {

    private final EnquiryService enquiryService;

    // Constructor
    public EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }

    // Create enquiry
    @PostMapping
    public ResponseEntity<Enquiry> createEnquiry(
            @RequestBody Enquiry enquiry) {

        Enquiry savedEnquiry =
                enquiryService.createEnquiry(enquiry);

        return ResponseEntity.ok(savedEnquiry);
    }

    // Get all enquiries
    @GetMapping
    public ResponseEntity<List<Enquiry>> getAllEnquiries() {

        return ResponseEntity.ok(
                enquiryService.getAllEnquiries()
        );
    }

    // Get enquiry by ID
    @GetMapping("/{id}")
    public ResponseEntity<Enquiry> getEnquiryById(
            @PathVariable Long id) {

        return enquiryService.getEnquiryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete enquiry
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnquiry(
            @PathVariable Long id) {

        enquiryService.deleteEnquiry(id);

        return ResponseEntity.noContent().build();
    }
}