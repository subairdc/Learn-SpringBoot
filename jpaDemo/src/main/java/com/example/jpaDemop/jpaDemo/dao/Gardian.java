package com.example.jpaDemop.jpaDemo.dao;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
//@Data
public class Gardian {

	String name;
	String relationShip;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelationShip() {
		return relationShip;
	}
	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gardian(String name, String relationShip, int age) {
		super();
		this.name = name;
		this.relationShip = relationShip;
		this.age = age;
	}
	public Gardian() {
		super();
	}

}
