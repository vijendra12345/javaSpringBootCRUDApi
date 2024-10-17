package com.demosprnigbootapi.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demosprnigbootapi.exception.CloudVenderNotFoundException;
import com.demosprnigbootapi.model.CloudVendor;
import com.demosprnigbootapi.repository.CloudVendorRepository;

@Service


public class CloudVendorServiceImpl implements CloudVendorService {
    private static final Logger logger = LoggerFactory.getLogger(CloudVendorServiceImpl.class);

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        try {
            cloudVendorRepository.save(cloudVendor);
            return "Save CloudVendor Successfully";
        } catch (Exception e) {
            logger.error("Error creating CloudVendor: {}", e.getMessage());
            return "Failed to save CloudVendor: " + e.getMessage();
        }
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        try {
            cloudVendorRepository.save(cloudVendor);
            return "Updated Successfully";
        } catch (Exception e) {
            logger.error("Error updating CloudVendor: {}", e.getMessage());
            return "Failed to update CloudVendor: " + e.getMessage();
        }
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        try {
            cloudVendorRepository.deleteById(cloudVendorId);
            return "Deleted successfully";
        } catch (Exception e) {
            logger.error("Error deleting CloudVendor: {}", e.getMessage());
            return "Failed to delete CloudVendor: " + e.getMessage();
        }
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        try {
            return cloudVendorRepository.findById(cloudVendorId)
                .orElseThrow(() -> new CloudVenderNotFoundException("CloudVendor Not Exist"));
        } catch (CloudVenderNotFoundException e) {
            logger.error("CloudVendor not found: {}", e.getMessage());
            throw e; // Rethrow the exception to be handled by the controller
        } catch (Exception e) {
            logger.error("Error fetching CloudVendor: {}", e.getMessage());
            throw new RuntimeException("Failed to fetch CloudVendor: " + e.getMessage());
        }
    }

    @Override
    public List<CloudVendor> getCloudVendors() {
        try {
            return cloudVendorRepository.findAll();
        } catch (Exception e) {
            logger.error("Error fetching CloudVendors: {}", e.getMessage());
            throw new RuntimeException("Failed to fetch CloudVendors: " + e.getMessage());
        }
    }
}
