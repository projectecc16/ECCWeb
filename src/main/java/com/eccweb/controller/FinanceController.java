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

import com.eccweb.entity.Finance;
import com.eccweb.resource.FinanceListResource;
import com.eccweb.resource.FinanceResource;
import com.eccweb.service.AccountService;
import com.eccweb.service.FinanceService;
import com.eccweb.util.Utils;


@Controller
@RequestMapping("/rest/app/finances")
public class FinanceController {
	
	@Autowired 
    private FinanceService financeService;
	@Autowired
    private AccountService accountService;
    
    @RequestMapping(method = RequestMethod.GET)
    //@PreAuthorize("permitAll")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<FinanceListResource> findAll(HttpServletResponse  response) {
    	
    	List<Finance> financeList = financeService.findAll();
    	Utils.setEncHeader(response, accountService);
    	FinanceListResource financeListRes = FinanceListResource.fromFinanceList(financeList);
        return new ResponseEntity<FinanceListResource>(financeListRes, HttpStatus.OK);
    }
    
    @RequestMapping(value="/{financeId}",
    		method = RequestMethod.GET)
    //@PreAuthorize("permitAll")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<FinanceResource> findFinance(@PathVariable Long financeId,HttpServletResponse  response)
    {
        Finance finance = financeService.find(financeId);
        if(finance != null) {
        	Utils.setEncHeader(response, accountService);
        	FinanceResource res = FinanceResource.fromFinance(finance);
            return new ResponseEntity<FinanceResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<FinanceResource>(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value="/{financeId}",
    		method = RequestMethod.DELETE)
    //@PreAuthorize("permitAll")
    @PreAuthorize("hasRole('CEO')")
    public ResponseEntity<FinanceResource> deleteFinance(@PathVariable Long financeId)
    {
        financeService.delete(financeId);
        return new ResponseEntity<FinanceResource>(HttpStatus.OK);
        
    }
    
	@RequestMapping(method = RequestMethod.POST)
	//@PreAuthorize("permitAll")
	@PreAuthorize("hasAnyRole('CEO','Manager_Finance')")
	public ResponseEntity<FinanceResource> create(@RequestBody FinanceResource financeRes,HttpServletResponse  response) {
		Finance createdFinance = financeService.create(financeRes.toFinance());
		Utils.setEncHeader(response, accountService);
		FinanceResource res = FinanceResource.fromFinance(createdFinance);
		return new ResponseEntity<FinanceResource>(res, HttpStatus.CREATED);

	}

    @RequestMapping(value="/{financeId}",
            method = RequestMethod.PUT)
    //@PreAuthorize("permitAll")
    @PreAuthorize("hasAnyRole('CEO','Engineer_Finance','Manager_Finance')")
    public ResponseEntity<FinanceResource> update(
            @PathVariable Long financeId, @RequestBody FinanceResource financeRes,HttpServletResponse  response) {
    	financeRes.setRid(financeId);
        Finance finance = financeService.update(financeRes.toFinance());
        if(finance != null)
        {
        	Utils.setEncHeader(response, accountService);
        	FinanceResource res = FinanceResource.fromFinance(finance);
            return new ResponseEntity<FinanceResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<FinanceResource>(HttpStatus.NOT_FOUND);
        }
    }
  
}
