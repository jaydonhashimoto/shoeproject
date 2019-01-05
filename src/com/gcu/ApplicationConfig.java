/**
 * Class: ApplicationConfig
 * Objective: To hold springbean configuration 
 * 
 */
package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.gcu.business.ProductBusinessService;
import com.gcu.business.ProductBusinessInterface;
import com.gcu.business.UserBusinessInterface;
import com.gcu.business.UserBusinessService;
import com.gcu.controller.ProductController;
import com.gcu.controller.UserController;

@Configuration
public class ApplicationConfig {
	@Bean(name="userController")
	public UserController getUserController()
	{
		return new UserController();
	}

	@Bean(name="userBusinessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UserBusinessInterface getUserService()
	{
		return new UserBusinessService();
	}
	
	@Bean(name="productController")
	public ProductController getProductController()
	{
		return new ProductController();
	}
	
	@Bean(name="productBusinessService" ,initMethod="init", destroyMethod="destroy")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ProductBusinessInterface getProductService()
	{
		return new ProductBusinessService();
	}	
}
