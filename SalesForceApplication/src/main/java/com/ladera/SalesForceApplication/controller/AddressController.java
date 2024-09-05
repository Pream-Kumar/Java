package com.ladera.SalesForceApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.SalesForceApplication.DTO.AddressDTO;
import com.ladera.SalesForceApplication.model.Address;
import com.ladera.SalesForceApplication.service.AddressService;

@RestController
@RequestMapping("/api/v2/salesforce/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/createAddress")
	public String createAddress(@RequestBody AddressDTO addressDTO) {
		System.out.println(addressDTO);
		addressService.createAddress(addressDTO);
		return "Address added successfully";
	}
	
	@GetMapping("/getAllAddress")
	public List<Address> getAllAddress(){
		return addressService.getAllAddress();
	}
}
