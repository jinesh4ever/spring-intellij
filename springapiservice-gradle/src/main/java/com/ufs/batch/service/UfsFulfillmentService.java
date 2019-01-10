package com.ufs.batch.service;

import java.util.List;

import com.ufs.batch.model.UfsFulfillment;

public interface UfsFulfillmentService {

	String saveUfsFulfillment(UfsFulfillment ufsFulfillment);
	
	UfsFulfillment getUfsFulfillmentByName(String name);
	
	UfsFulfillment getUfsFulfillmentById(String id);

	String updateUfsFulfillment(UfsFulfillment ufsFulfillment);

	String delUfsFulfillment(UfsFulfillment ufsFulfillment);

	List<UfsFulfillment> getUfsFulfillments();

	List<UfsFulfillment> getUfsFulfillmentsByVendor(String vendor);
}

