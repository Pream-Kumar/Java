package com.ladera.SalesForceApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.SalesForceApplication.DTO.OrderDTO;
import com.ladera.SalesForceApplication.model.OrderModel;
import com.ladera.SalesForceApplication.service.OrderService;

@RestController
@RequestMapping("/api/v2/salesforce/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("createOrder")
	public String createOrder(@RequestBody OrderDTO orderDto) {
		String status = orderService.createOrder(orderDto);
		return status;
		
	}
	
	@GetMapping("/getOrder")
	public OrderModel getOrder(@RequestParam Integer orderId) {
		System.out.println("Order Code "+orderId);
		OrderModel order = orderService.getOrder(orderId);
		return order;
	}
	
	@GetMapping("/getOrderTotal")
	public double getOrderTotal(@RequestParam Integer orderId) {
		double orderTotal = orderService.getOrderTotal(orderId);
		return orderTotal;
	}
   
}
