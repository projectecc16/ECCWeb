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

import com.eccweb.entity.Sales;
import com.eccweb.resource.SalesListResource;
import com.eccweb.resource.SalesResource;
import com.eccweb.service.AccountService;
import com.eccweb.service.SalesService;
import com.eccweb.util.Utils;


@Controller
@RequestMapping("/rest/app/saless")
public class SalesController {
	
	@Autowired 
    private SalesService salesService;
	@Autowired
    private AccountService accountService;
    
    @RequestMapping(method = RequestMethod.GET)
    //@PreAuthorize("permitAll")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<SalesListResource> findAll(HttpServletResponse  response) {
    	
    	List<Sales> salesList = salesService.findAll();
    	Utils.setEncHeader(response, accountService);
    	SalesListResource salesListRes = SalesListResource.fromSalesList(salesList);
        return new ResponseEntity<SalesListResource>(salesListRes, HttpStatus.OK);
    }
    
    @RequestMapping(value="/{salesId}",
    		method = RequestMethod.GET)
    //@PreAuthorize("permitAll")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<SalesResource> findSales(@PathVariable Long salesId,HttpServletResponse  response)
    {
        Sales sales = salesService.find(salesId);
        if(sales != null) {
        	Utils.setEncHeader(response, accountService);
        	SalesResource res = SalesResource.fromSales(sales);
            return new ResponseEntity<SalesResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<SalesResource>(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value="/{salesId}",
    		method = RequestMethod.DELETE)
    //@PreAuthorize("permitAll")
    @PreAuthorize("hasRole('CEO')")
    public ResponseEntity<SalesResource> deleteSales(@PathVariable Long salesId)
    {
        salesService.delete(salesId);
        return new ResponseEntity<SalesResource>(HttpStatus.OK);
        
    }
    
	@RequestMapping(method = RequestMethod.POST)
	//@PreAuthorize("permitAll")
	@PreAuthorize("hasAnyRole('CEO','Manager_Sales')")
	public ResponseEntity<SalesResource> create(@RequestBody SalesResource salesRes,HttpServletResponse  response) {
		Sales createdSales = salesService.create(salesRes.toSales());
		Utils.setEncHeader(response, accountService);
		SalesResource res = SalesResource.fromSales(createdSales);
		return new ResponseEntity<SalesResource>(res, HttpStatus.CREATED);

	}

    @RequestMapping(value="/{salesId}",
            method = RequestMethod.PUT)
    //@PreAuthorize("permitAll")
    @PreAuthorize("hasAnyRole('CEO','Engineer_Sales','Manager_Sales')")
    public ResponseEntity<SalesResource> update(
            @PathVariable Long salesId, @RequestBody SalesResource salesRes,HttpServletResponse  response) {
    	salesRes.setRid(salesId);
        Sales sales = salesService.update(salesRes.toSales());
        if(sales != null)
        {
        	Utils.setEncHeader(response, accountService);
        	SalesResource res = SalesResource.fromSales(sales);
            return new ResponseEntity<SalesResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<SalesResource>(HttpStatus.NOT_FOUND);
        }
    }
  
}
