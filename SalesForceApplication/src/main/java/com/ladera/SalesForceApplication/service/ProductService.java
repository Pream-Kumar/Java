package com.ladera.SalesForceApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladera.SalesForceApplication.DTO.ProductDTO;
import com.ladera.SalesForceApplication.model.Product;
import com.ladera.SalesForceApplication.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public void createProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setProductCode(productDTO.getProductCode());
		product.setDescription(productDTO.getDescription());
		product.setProductStatus(productDTO.getProductStatus());
//		product.setQuantity(productDTO.getQuantity());
		// product.setProductType(productType.get);
		productRepository.save(product);
	}
	public List<Product> getAllProduct() {
		List<Product> productList = productRepository.findAll();
		return productList;
	}
}
