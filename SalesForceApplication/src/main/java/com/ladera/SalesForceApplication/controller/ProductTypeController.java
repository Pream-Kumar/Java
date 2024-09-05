package com.ladera.SalesForceApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.SalesForceApplication.DTO.ProductTypeDTO;
import com.ladera.SalesForceApplication.service.ProductTypeService;

@RestController
@RequestMapping("/api/v2/salesforce/productType")
public class ProductTypeController {
	@Autowired
	private ProductTypeService productTypeService;
	
	@PostMapping("/createProductType")
	public String createProductType(@RequestBody ProductTypeDTO productTypeDTO) {
		productTypeService.createProductType(productTypeDTO);
		return "Product Type added successfully";
	}
}
