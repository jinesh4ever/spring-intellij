package com.ufs.batch.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ufs_batch_process", schema = "public")
public class UfsBatchProcess {

	private static final long serialVersionUID = -751325932836629843L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ufs_batch_process_id")
	private Long ufs_batch_process_id;

	@Column(name = "vendor", nullable = false, unique = true)
	private String vendor;

	@Column(name = "status", nullable = false)
	private boolean status;

	@Column(name = "vendor_category", nullable = false)
	private String vendor_category;

	@Column(name = "processed_time", nullable = false)
	private Timestamp processed_time;

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getVendor_category() {
		return vendor_category;
	}

	public void setVendor_category(String vendor_category) {
		this.vendor_category = vendor_category;
	}

	public Timestamp getProcessed_time() {
		return processed_time;
	}

	public void setProcessed_time(Timestamp processed_time) {
		this.processed_time = processed_time;
	}

	public Long getUfs_batch_process_id() {
		return ufs_batch_process_id;
	}

	public void setUfs_batch_process_id(Long ufs_batch_process_id) {
		this.ufs_batch_process_id = ufs_batch_process_id;
	}

	@Override
	public String toString() {
		return "UfsBatchProcess [ufs_batch_process_id=" + ufs_batch_process_id + ", vendor=" + vendor + ", status="
				+ status + ", vendor_category=" + vendor_category + ", processed_time=" + processed_time + "]";
	}
	
	

}