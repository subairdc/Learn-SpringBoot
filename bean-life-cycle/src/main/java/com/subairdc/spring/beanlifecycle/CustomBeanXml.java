package com.subairdc.spring.beanlifecycle;

public class CustomBeanXml {

	private String message;

	public CustomBeanXml() {
		super();
	}

	public CustomBeanXml(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	 public void init() {
		 System.out.println("Bean is going through init.");
	 }

	 public void destroy() {
		 System.out.println("Bean will destroy now.");
	 }
	
	public void display() {
        System.out.println("Message: " + message);
    }
	
}
