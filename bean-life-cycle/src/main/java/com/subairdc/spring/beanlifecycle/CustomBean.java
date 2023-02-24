package com.subairdc.spring.beanlifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class CustomBean {
	
	private String message;

	public CustomBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@PostConstruct //The @PostConstruct method is called after all the properties of the bean have been set
    public void init() {
        System.out.println("Bean is going through init.");
    }

    @PreDestroy  //the @PreDestroy method is called when the bean is being destroyed.
    public void destroy() {
        System.out.println("Bean will destroy now.");
    }

    public void display() {
        System.out.println("Message: " + message);
    }
	
	

}
