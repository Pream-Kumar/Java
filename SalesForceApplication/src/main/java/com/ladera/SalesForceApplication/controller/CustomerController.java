package com.ladera.SalesForceApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.SalesForceApplication.DTO.CustomerDTO;
import com.ladera.SalesForceApplication.model.Customer;
import com.ladera.SalesForceApplication.service.CustomerService;

@RestController
@RequestMapping("/api/v2/salesforce/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/createCustomer")
	public String createCustomer(@RequestBody CustomerDTO customerDTO) {
		System.out.println(customerDTO);
		customerService.createCustomer(customerDTO);
		return "Customer added successfully";
	}

	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
}
