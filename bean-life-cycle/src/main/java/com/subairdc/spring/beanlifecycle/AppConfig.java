package com.subairdc.spring.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	 @Bean
	 public CustomBean customBean() {
		 CustomBean bean = new CustomBean();
	     bean.setMessage("Hello, world!");
	     return bean;
	 }

}
