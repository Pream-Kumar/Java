package com.ladera.SalesForceApplication.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladera.SalesForceApplication.DTO.CustomerDTO;
import com.ladera.SalesForceApplication.model.Customer;
import com.ladera.SalesForceApplication.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public void createCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		customerRepository.save(customer);
	}

	public List<Customer> getAllCustomer() {
		List<Customer> customerList = customerRepository.findAll();
		return customerList;
	}
}
