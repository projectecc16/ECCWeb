package com.eccweb.resource;


import com.eccweb.entity.Account;
import com.eccweb.entity.Production;
import com.eccweb.entity.HR;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HRResource {
	private Long rid;
	 private String employeeName;
	 private String employeeTitle;
	 private String employeeDept;
	 private Long employeePhone;
	 private String employeeEmail;
	
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
    
    public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeTitle() {
		return employeeTitle;
	}

	public void setEmployeeTitle(String employeeTitle) {
		this.employeeTitle = employeeTitle;
	}

	public String getEmployeeDept() {
		return employeeDept;
	}

	public void setEmployeeDept(String employeeDept) {
		this.employeeDept = employeeDept;
	}

	public Long getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(Long employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public HR toHR() {
    	HR hr = new HR();
    	hr.setId(rid);
    	hr.setEmployeeDept(employeeDept);
    	hr.setEmployeeEmail(employeeEmail);
    	hr.setEmployeeName(employeeName);
    	hr.setEmployeePhone(employeePhone);
    	hr.setEmployeeTitle(employeeTitle);
        return hr;
    }
    
    public static HRResource fromHR(HR hr) {
    	HRResource hrRes = new HRResource();
    	hrRes.setRid(hr.getId());
    	hrRes.setEmployeeDept(hr.getEmployeeDept());
    	hrRes.setEmployeeEmail(hr.getEmployeeEmail());
    	hrRes.setEmployeeName(hr.getEmployeeName());
    	hrRes.setEmployeePhone(hr.getEmployeePhone());
    	hrRes.setEmployeeTitle(hr.getEmployeeTitle());
    	return hrRes;
    }
}
