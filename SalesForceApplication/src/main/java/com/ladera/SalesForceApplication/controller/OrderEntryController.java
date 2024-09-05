package com.ladera.SalesForceApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.SalesForceApplication.DTO.OrderEntryDTO;
import com.ladera.SalesForceApplication.model.OrderEntry;
import com.ladera.SalesForceApplication.service.OrderEntryService;


@RestController
@RequestMapping("/api/v2/salesforce/orderEntry")
public class OrderEntryController {
	
	@Autowired
	OrderEntryService orderEntryService;
	
	
	@PostMapping("/createOrderEntry/{order_id}/{product_id}")
	public String createOrderEntry(@PathVariable Integer order_id,@PathVariable Integer product_id, @RequestBody OrderEntryDTO orderEntryDto){
		
		
		String orderEntry = orderEntryService.createOrderEntry(order_id,product_id, orderEntryDto);
		return orderEntry;
	}
	
	@GetMapping("/getOrderEntryForOrder")
	public List<OrderEntry> getOrderEntryForOrder(@RequestParam Integer orderId) {
		List<OrderEntry> orderEntryList = orderEntryService.getOrderEntryForOrder(orderId); 
		return orderEntryList;
	}
}
