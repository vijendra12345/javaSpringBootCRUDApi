package com.demosprnigbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demosprnigbootapi.model.CloudVendor;
@Repository
public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
	// here we write the custom methods if jpa not provided

}
