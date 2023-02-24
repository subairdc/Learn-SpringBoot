package com.subairdc.springsecuritydemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subairdc.springsecuritydemo.dto.Product;
import com.subairdc.springsecuritydemo.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

//    List<Product> productList = null;

//    @PostConstruct
//    public void loadProductsFromDB() {
//        productList = IntStream.rangeClosed(1, 100)
//                .mapToObj(i -> Product.builder()
//                        .productId(i)
//                        .name("product " + i)
//                        .qty(new Random().nextInt(10))
//                        .price(new Random().nextInt(5000)).build()
//                ).collect(Collectors.toList());
//    }


    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProduct(int id) {
    	
//    	List<Product> productList = repository.findAll();
//        productList.stream()
//        	.filter(product -> product.getProductId() == id)
//            .findAny()
//            .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
    	
    	return repository.findById(id).orElse(null);
    }


	public String addNewProduct(Product product) {
		repository.save(product);
		return "Product Save Successfully";
	}
	
	public String addNewProducts(List<Product> product) {
		repository.saveAll(product);
		return "Products Save Successfully";
	}
}