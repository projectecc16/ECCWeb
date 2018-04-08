package com.eccweb.resource;


import com.eccweb.entity.Account;
import com.eccweb.entity.Production;
import com.eccweb.entity.Finance;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FinanceResource {
	private Long rid;
	private String projectName;
	private Long budget;
	private Long cashInBank;
	private Long wages;
	private Long overdraft;
	
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
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

	public Finance toFinance() {
    	Finance finance = new Finance();
    	finance.setId(rid);
    	finance.setBudget(budget);
    	finance.setCashInBank(cashInBank);
    	finance.setOverdraft(overdraft);
    	finance.setProjectName(projectName);
    	finance.setWages(wages);
    	return finance;
    }
    
    public static FinanceResource fromFinance(Finance finance) {
    	FinanceResource financeRes = new FinanceResource();
    	financeRes.setRid(finance.getId());
    	financeRes.setBudget(finance.getBudget());
    	financeRes.setCashInBank(finance.getCashInBank());
    	financeRes.setOverdraft(finance.getOverdraft());
    	financeRes.setProjectName(finance.getProjectName());
    	financeRes.setWages(finance.getWages());
    	return financeRes;
    }
}
