package com.ladera.SalesForceApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.SalesForceApplication.DTO.ProductDTO;
import com.ladera.SalesForceApplication.model.Product;
import com.ladera.SalesForceApplication.service.ProductService;

@RestController
@RequestMapping("/api/v2/salesforce/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/createProduct")
	public String createProduct(@RequestBody ProductDTO productDTO) {
		System.out.println("createproduct");
		productService.createProduct(productDTO);
		return "Product added successfully";
	}
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}
}
