package com.subairdc.spring.beanlifecycle;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BeanLifeCycleApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BeanLifeCycleApplication.class, args);
		
		//Annotation Method
//		ConfigurableApplicationContext context = SpringApplication.run(BeanLifeCycleApplication.class, args);
//        CustomBean customBean = context.getBean(CustomBean.class);
//        customBean.display();
//        context.close();
        
		//XML Configuration Method
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CustomBeanXml customBeanXml = (CustomBeanXml) context.getBean("customBeanXml");
        customBeanXml.display();
        ((ClassPathXmlApplicationContext) context).close();
        	
	}

}
