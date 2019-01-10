package com.ufs.batch.dao;

import java.util.List;

import com.ufs.batch.model.UfsFulfillment;

public interface UfsFulfillmentDao {

	List<UfsFulfillment> getUfsFulfillments();

	String saveUfsFulfillment(UfsFulfillment ufsFulFillment);

	UfsFulfillment getUfsFulfillmentByName(String name);

	String updateUfsFulfillment(UfsFulfillment ufsFulFillment);

	String delUfsFulfillment(UfsFulfillment ufsFulFillment);

	List<UfsFulfillment> getUfsFulfillmentsByVendor(String vendor);

	UfsFulfillment getUfsFulfillmentById(String id);

}
