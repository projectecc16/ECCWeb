package com.eccweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Production {
	 @Id @GeneratedValue
	 private Long id;
	 private String machine;
	 private String powerConception;
	 private Long noOfWorkers;
	 private Long noOfJobs;
	 private String serviceEngineer;
//	 private Date beginDate;
//	 private Date endDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	public String getPowerConception() {
		return powerConception;
	}
	public void setPowerConception(String powerConception) {
		this.powerConception = powerConception;
	}
	public Long getNoOfWorkers() {
		return noOfWorkers;
	}
	public void setNoOfWorkers(Long noOfWorkers) {
		this.noOfWorkers = noOfWorkers;
	}
	public Long getNoOfJobs() {
		return noOfJobs;
	}
	public void setNoOfJobs(Long noOfJobs) {
		this.noOfJobs = noOfJobs;
	}
	public String getServiceEngineer() {
		return serviceEngineer;
	}
	public void setServiceEngineer(String serviceEngineer) {
		this.serviceEngineer = serviceEngineer;
	}
	 
}
