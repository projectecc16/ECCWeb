package com.eccweb.util;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.eccweb.entity.Account;
import com.eccweb.service.AccountService;

public class Utils {
	public static void setEncHeader(HttpServletResponse  response, AccountService accountService){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String name = auth.getName();
    	Account account = accountService.findByAccountName(name);
        if(account != null && account.isEncryption()) {
        	response.setHeader("X-ENC-DATA", "true");
        }
	}
}
