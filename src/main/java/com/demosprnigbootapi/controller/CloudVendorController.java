package com.demosprnigbootapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demosprnigbootapi.exception.CloudVenderNotFoundException;
import com.demosprnigbootapi.model.CloudVendor;
import com.demosprnigbootapi.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    private static final Logger logger = LoggerFactory.getLogger(CloudVendorController.class);

    @Autowired
    private CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}")
    public ResponseEntity<CloudVendor> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        try {
            CloudVendor cloudVendor = cloudVendorService.getCloudVendor(vendorId);
            return ResponseEntity.ok(cloudVendor);
        } catch (CloudVenderNotFoundException e) {
            logger.error("CloudVendor not found: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            logger.error("Error fetching CloudVendor: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping()
    public ResponseEntity<List<CloudVendor>> getAllCloudVendors() {
        logger.trace("Starting get all cloud vendors method with trace log level");
        logger.info("Starting get all cloud vendors method with info log level");
        try {
            List<CloudVendor> vendors = cloudVendorService.getCloudVendors();
            return ResponseEntity.ok(vendors);
        } catch (Exception e) {
            logger.error("Error fetching all CloudVendors: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping()
    public ResponseEntity<String> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        try {
            String response = cloudVendorService.createCloudVendor(cloudVendor);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            logger.error("Error creating CloudVendor: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create CloudVendor: " + e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<String> updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        try {
            String response = cloudVendorService.updateCloudVendor(cloudVendor);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error updating CloudVendor: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update CloudVendor: " + e.getMessage());
        }
    }

    @DeleteMapping("{vendorId}")
    public ResponseEntity<String> deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        try {
            String response = cloudVendorService.deleteCloudVendor(vendorId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error deleting CloudVendor: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete CloudVendor: " + e.getMessage());
        }
    }
}
