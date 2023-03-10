package com.subairdc.springsecuritydemo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Entity
public class Product {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int productId;
	private String name;
	private int qty;
	private double price;

}
