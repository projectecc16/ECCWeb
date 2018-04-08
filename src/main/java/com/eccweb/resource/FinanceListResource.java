package com.eccweb.resource;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.eccweb.entity.Finance;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinanceListResource extends ResourceSupport {
    private List<FinanceResource> finances = new ArrayList<FinanceResource>();

    public List<FinanceResource> getFinances() {
        return finances;
    }

    public void setFinances(List<FinanceResource> finances) {
        this.finances = finances;
    }
    
    public static FinanceListResource fromFinanceList(List<Finance> financeList) {
    	FinanceListResource financeListRes = new FinanceListResource();
    	List<FinanceResource> financeRes = new ArrayList<FinanceResource>();
    	for(Finance finance: financeList){
    		financeRes.add(FinanceResource.fromFinance(finance));
    	}
    	financeListRes.setFinances(financeRes);
        return financeListRes;
    }
}
