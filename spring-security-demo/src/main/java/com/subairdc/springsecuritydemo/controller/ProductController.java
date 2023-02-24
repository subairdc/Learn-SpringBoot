package com.subairdc.springsecuritydemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subairdc.springsecuritydemo.dto.Product;
import com.subairdc.springsecuritydemo.entity.UserInfo;
import com.subairdc.springsecuritydemo.service.ProductService;
import com.subairdc.springsecuritydemo.service.UserInfoService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;
    
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return userInfoService.addNewUser(userInfo);
    }

    @PostMapping("/addNewProduct")
    public String addNewProduct(@RequestBody Product product){
      return service.addNewProduct(product);
    }
    
    @PostMapping("/addNewProducts")
    public String addNewProducts(@RequestBody List<Product> product){
      return service.addNewProducts(product);
    }
    
    @GetMapping("/getAllProducts")
    @PreAuthorize("hasAuthority('ADMIN')") //admin only allow to access //use ROLE_ADMIN for Hard code
    public List<Product> getAllTheProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Product getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }
}