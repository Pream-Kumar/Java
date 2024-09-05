package com.ladera.SalesForceApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladera.SalesForceApplication.DTO.ProductTypeDTO;
import com.ladera.SalesForceApplication.repository.ProductRepository;

@Service
public class ProductTypeService {
//	@Autowired
//	private ProductTypeRepository productTypeRepository;

	@Autowired
	private ProductRepository productRepository;

	public void createProductType(ProductTypeDTO productTypeDTO) {

//		ProductType productType = new ProductType();
//		productType.setName(productTypeDTO.getName());
//		productTypeRepository.save(productType);

	}

//	public List<ProductType> getAllProductType() {
////		List<ProductType> productTypeList = productTypeRepository.findAll();
////		return productTypeList;
//	}
}
