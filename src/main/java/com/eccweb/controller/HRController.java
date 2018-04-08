package com.eccweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eccweb.entity.HR;
import com.eccweb.resource.HRListResource;
import com.eccweb.resource.HRResource;
import com.eccweb.service.AccountService;
import com.eccweb.service.HRService;
import com.eccweb.util.Utils;


@Controller
@RequestMapping("/rest/app/hrs")
public class HRController {
	
	@Autowired 
    private HRService hrService;
	@Autowired
    private AccountService accountService;
    
    @RequestMapping(method = RequestMethod.GET)
    //@PreAuthorize("permitAll")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<HRListResource> findAll(HttpServletResponse  response) {
    	
    	List<HR> hrList = hrService.findAll();
    	Utils.setEncHeader(response, accountService);
    	HRListResource hrListRes = HRListResource.fromHRList(hrList);
        return new ResponseEntity<HRListResource>(hrListRes, HttpStatus.OK);
    }
    
    @RequestMapping(value="/{hrId}",
    		method = RequestMethod.GET)
    //@PreAuthorize("permitAll")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<HRResource> findHR(@PathVariable Long hrId,HttpServletResponse  response)
    {
        HR hr = hrService.find(hrId);
        if(hr != null) {
        	Utils.setEncHeader(response, accountService);
        	HRResource res = HRResource.fromHR(hr);
            return new ResponseEntity<HRResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<HRResource>(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value="/{hrId}",
    		method = RequestMethod.DELETE)
    //@PreAuthorize("permitAll")
    @PreAuthorize("hasRole('CEO')")
    public ResponseEntity<HRResource> deleteHR(@PathVariable Long hrId)
    {
        hrService.delete(hrId);
        return new ResponseEntity<HRResource>(HttpStatus.OK);
        
    }
    
	@RequestMapping(method = RequestMethod.POST)
	//@PreAuthorize("permitAll")
	@PreAuthorize("hasAnyRole('CEO','Manager_HR')")
	public ResponseEntity<HRResource> create(@RequestBody HRResource hrRes,HttpServletResponse  response) {
		HR createdHR = hrService.create(hrRes.toHR());
		Utils.setEncHeader(response, accountService);
		HRResource res = HRResource.fromHR(createdHR);
		return new ResponseEntity<HRResource>(res, HttpStatus.CREATED);

	}

    @RequestMapping(value="/{hrId}",
            method = RequestMethod.PUT)
    //@PreAuthorize("permitAll")
    @PreAuthorize("hasAnyRole('CEO','Engineer_HR','Manager_HR')")
    public ResponseEntity<HRResource> update(
            @PathVariable Long hrId, @RequestBody HRResource hrRes,HttpServletResponse  response) {
    	hrRes.setRid(hrId);
        HR hr = hrService.update(hrRes.toHR());
        if(hr != null)
        {
        	Utils.setEncHeader(response, accountService);
        	HRResource res = HRResource.fromHR(hr);
            return new ResponseEntity<HRResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<HRResource>(HttpStatus.NOT_FOUND);
        }
    }
  
}
