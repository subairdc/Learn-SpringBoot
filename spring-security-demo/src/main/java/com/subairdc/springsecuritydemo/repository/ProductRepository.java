package com.subairdc.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subairdc.springsecuritydemo.dto.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
 