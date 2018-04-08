package com.eccweb.resource;


import com.eccweb.entity.Production;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductionResource {
	private Long rid;
	private String machine;
	private String powerConception;
	private Long noOfWorkers;
	private Long noOfJobs;
	private String serviceEngineer;
	
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
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
    public Production toProduction() {
        Production production = new Production();
        production.setId(rid);
        production.setMachine(machine);
        production.setNoOfJobs(noOfJobs);
        production.setNoOfWorkers(noOfWorkers);
        production.setPowerConception(powerConception);
        production.setServiceEngineer(serviceEngineer);
        return production;
    }
    
    public static ProductionResource fromProduction(Production production) {
    	ProductionResource prodRes = new ProductionResource();
    	prodRes.setRid(production.getId());
    	prodRes.setMachine(production.getMachine());
    	prodRes.setNoOfJobs(production.getNoOfJobs());
    	prodRes.setNoOfWorkers(production.getNoOfWorkers());
    	prodRes.setPowerConception(production.getPowerConception());
    	prodRes.setServiceEngineer(production.getServiceEngineer());
        return prodRes;
    }
}
