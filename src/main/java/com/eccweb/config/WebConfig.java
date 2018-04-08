package com.eccweb.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.eccweb.converter.CustomMessageConverter;
import com.eccweb.service.AccountService;
import com.eccweb.service.CryptoService;

//@EnableWebMvc
//@ComponentScan
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	
	@Autowired
    private AccountService accountService;
 
	
	 @Bean
	 public CustomMessageConverter customJackson2HttpMessageConverter() {
		 CustomMessageConverter jsonConverter = new CustomMessageConverter(accountService);
	  return jsonConverter;
	 }
	 
	 @Override
	 public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
		 messageConverters.add(customJackson2HttpMessageConverter());
	  StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
		stringConverter.setWriteAcceptCharset(false);

		messageConverters.add(new ByteArrayHttpMessageConverter());
		messageConverters.add(stringConverter);
		messageConverters.add(new ResourceHttpMessageConverter());
		//messageConverters.add(new AllEncompassingFormHttpMessageConverter());
	  //super.addDefaultHttpMessageConverters(converters);	  
	 }
}