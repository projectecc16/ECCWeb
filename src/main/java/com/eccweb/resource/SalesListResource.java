package com.eccweb.resource;
import org.springframework.hateoas.ResourceSupport;

import com.eccweb.entity.Production;
import com.eccweb.entity.Sales;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesListResource extends ResourceSupport {
    private List<SalesResource> saless = new ArrayList<SalesResource>();

    public List<SalesResource> getSaless() {
        return saless;
    }

    public void setSaless(List<SalesResource> saless) {
        this.saless = saless;
    }
    
    public static SalesListResource fromSalesList(List<Sales> salesList) {
    	SalesListResource salesListRes = new SalesListResource();
    	List<SalesResource> salesRes = new ArrayList<SalesResource>();
    	for(Sales sales: salesList){
    		salesRes.add(SalesResource.fromSales(sales));
    	}
    	salesListRes.setSaless(salesRes);
        return salesListRes;
    }
}
