package com.eccweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Finance {
	 @Id @GeneratedValue
	 private Long id;
	 private String projectName;
	 private Long budget;
	 private Long cashInBank;
	 private Long wages;
	 private Long overdraft;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Long getBudget() {
		return budget;
	}
	public void setBudget(Long budget) {
		this.budget = budget;
	}
	public Long getCashInBank() {
		return cashInBank;
	}
	public void setCashInBank(Long cashInBank) {
		this.cashInBank = cashInBank;
	}
	public Long getWages() {
		return wages;
	}
	public void setWages(Long wages) {
		this.wages = wages;
	}
	public Long getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(Long overdraft) {
		this.overdraft = overdraft;
	}
	
	 
}
