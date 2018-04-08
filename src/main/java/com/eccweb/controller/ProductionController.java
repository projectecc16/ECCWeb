package com.eccweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eccweb.entity.Account;
import com.eccweb.entity.Production;
import com.eccweb.resource.AccountResource;
import com.eccweb.resource.ProductionListResource;
import com.eccweb.resource.ProductionResource;
import com.eccweb.service.AccountService;
import com.eccweb.service.ProductionService;
import com.eccweb.util.Utils;


@Controller
@RequestMapping("/rest/app/productions")
public class ProductionController {
	
	@Autowired 
    private ProductionService productionService;
	@Autowired
    private AccountService accountService;
    
    @RequestMapping(method = RequestMethod.GET)
    //@PreAuthorize("permitAll")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ProductionListResource> findAllProduction(HttpServletResponse  response) {
    	
    	List<Production> productionList = productionService.findAllProduction();
    	Utils.setEncHeader(response, accountService);
    	ProductionListResource prodListRes = ProductionListResource.fromProductionList(productionList);
        return new ResponseEntity<ProductionListResource>(prodListRes, HttpStatus.OK);
    }
    
    @RequestMapping(value="/{productionId}",
    		method = RequestMethod.GET)
    //@PreAuthorize("permitAll")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ProductionResource> findProduction(@PathVariable Long productionId,HttpServletResponse  response)
    {
        Production production = productionService.findProduction(productionId);
        if(production != null) {
        	Utils.setEncHeader(response, accountService);
        	ProductionResource res = ProductionResource.fromProduction(production);
            return new ResponseEntity<ProductionResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ProductionResource>(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value="/{productionId}",
    		method = RequestMethod.DELETE)
    //@PreAuthorize("permitAll")
    @PreAuthorize("hasRole('CEO')")
    public ResponseEntity<ProductionResource> deleteProduction(@PathVariable Long productionId)
    {
        productionService.deleteProduction(productionId);
        return new ResponseEntity<ProductionResource>(HttpStatus.OK);
        
    }
    
	@RequestMapping(method = RequestMethod.POST)
	//@PreAuthorize("permitAll")
	@PreAuthorize("hasAnyRole('CEO','Manager_Production')")
	public ResponseEntity<ProductionResource> createProduction(@RequestBody ProductionResource productionRes,HttpServletResponse  response) {
		Production createdProduction = productionService.createProduction(productionRes.toProduction());
		Utils.setEncHeader(response, accountService);
		ProductionResource res = ProductionResource.fromProduction(createdProduction);
		return new ResponseEntity<ProductionResource>(res, HttpStatus.CREATED);

	}

    @RequestMapping(value="/{productionId}",
            method = RequestMethod.PUT)
    //@PreAuthorize("permitAll")
    @PreAuthorize("hasAnyRole('CEO','Engineer_Production','Manager_Production')")
    public ResponseEntity<ProductionResource> updateProduction(
            @PathVariable Long productionId, @RequestBody ProductionResource productionRes,HttpServletResponse  response) {
    	productionRes.setRid(productionId);
        Production production = productionService.updateProduction(productionRes.toProduction());
        if(production != null)
        {
        	Utils.setEncHeader(response, accountService);
        	ProductionResource res = ProductionResource.fromProduction(production);
            return new ResponseEntity<ProductionResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ProductionResource>(HttpStatus.NOT_FOUND);
        }
    }
  
}
