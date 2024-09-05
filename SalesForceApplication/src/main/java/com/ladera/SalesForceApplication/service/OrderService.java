package com.ladera.SalesForceApplication.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ladera.SalesForceApplication.DTO.OrderDTO;
import com.ladera.SalesForceApplication.model.Customer;
import com.ladera.SalesForceApplication.model.OrderEntry;
import com.ladera.SalesForceApplication.model.OrderModel;
import com.ladera.SalesForceApplication.repository.CustomerRepository;
import com.ladera.SalesForceApplication.repository.IOrderEntryRepository;
import com.ladera.SalesForceApplication.repository.IOrderRepository;

@Service
public class OrderService {
	
	
	String pricefxUrl = "http://localhost:8888/api/v4/pricefx/discountCalculation";

	@Autowired
	IOrderRepository orderRepository;

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	IOrderEntryRepository orderEntryRepository;
	
	@Autowired
	RestTemplate restTemplate;

	public String createOrder(OrderDTO orderDto) {
		OrderModel orderModel = new OrderModel();

		BeanUtils.copyProperties(orderDto, orderModel);
		Customer customer = customerRepository.findById(orderDto.getCustomer_id()).get();
		orderModel.setCustomer(customer);

		OrderModel savedOrder = orderRepository.save(orderModel);

		if (Objects.nonNull(savedOrder)) {
			return "Order saved successfully";
		}

		return "order invalid";

	}
	
	public OrderModel getOrder(Integer orderId) {
		System.out.println("orderCode in ser "+orderId);
		OrderModel orderModel = orderRepository.findById(orderId).get();
		System.out.println("orderModel "+orderModel);
		return orderModel;
		
	}
	public double getOrderTotal(Integer orderId) {
		OrderModel orderModel = orderRepository.findById(orderId).get();
		List<OrderEntry> orderEntries = orderEntryRepository.findByOrderModel(orderModel);
		for (OrderEntry orderEntry : orderEntries) {
			if(orderEntry.getQuantity()>1) {
				double entryTotal =orderEntry.getEntryTotal();
				Double discountedEntryTotal = restTemplate.getForObject(pricefxUrl+"/"+entryTotal,Double.class);
				System.out.println("discountedEntryTotal "+discountedEntryTotal);
				orderEntry.setEntryTotal(discountedEntryTotal);
			}
		}
		Double orderTotal = orderEntries.stream().
				collect(Collectors.summingDouble(OrderEntry::getEntryTotal));
		return orderTotal;
		
	}
}
