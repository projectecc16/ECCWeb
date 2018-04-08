package com.eccweb.resource;
import org.springframework.hateoas.ResourceSupport;

import com.eccweb.entity.Production;
import com.eccweb.entity.HR;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class HRListResource extends ResourceSupport {
    private List<HRResource> hrs = new ArrayList<HRResource>();

    public List<HRResource> getHrs() {
        return hrs;
    }

    public void setHrs(List<HRResource> hrs) {
        this.hrs = hrs;
    }
    
    public static HRListResource fromHRList(List<HR> hrList) {
    	HRListResource hrListRes = new HRListResource();
    	List<HRResource> hrRes = new ArrayList<HRResource>();
    	for(HR hr: hrList){
    		hrRes.add(HRResource.fromHR(hr));
    	}
    	hrListRes.setHrs(hrRes);
        return hrListRes;
    }
}
