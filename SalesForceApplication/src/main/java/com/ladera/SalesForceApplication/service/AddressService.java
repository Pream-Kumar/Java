package com.ladera.SalesForceApplication.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladera.SalesForceApplication.DTO.AddressDTO;
import com.ladera.SalesForceApplication.model.Address;
import com.ladera.SalesForceApplication.model.Customer;
import com.ladera.SalesForceApplication.repository.AddressRepository;
import com.ladera.SalesForceApplication.repository.CustomerRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void createAddress(AddressDTO addressDTO) {
		Address address = new Address();
		Customer customer = customerRepository.findById(addressDTO.getCustomer_id()).get();
		BeanUtils.copyProperties(addressDTO, address);
		address.setCustomer(customer);
		addressRepository.save(address);
	}
	
	public List<Address> getAllAddress() {
		List<Address> addressList = addressRepository.findAll();
		return addressList;
	}
}
