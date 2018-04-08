package com.eccweb.resource;
import org.springframework.hateoas.ResourceSupport;

import com.eccweb.entity.Production;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductionListResource extends ResourceSupport {
    private List<ProductionResource> productions = new ArrayList<ProductionResource>();

    public List<ProductionResource> getProductions() {
        return productions;
    }

    public void setProductions(List<ProductionResource> productions) {
        this.productions = productions;
    }
    
    public static ProductionListResource fromProductionList(List<Production> prodList) {
    	ProductionListResource prodListRes = new ProductionListResource();
    	List<ProductionResource> prodsRes = new ArrayList<ProductionResource>();
    	for(Production prod: prodList){
    		prodsRes.add(ProductionResource.fromProduction(prod));
    	}
    	prodListRes.setProductions(prodsRes);
        return prodListRes;
    }
}
