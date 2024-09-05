package com.ladera.SalesForceApplication.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladera.SalesForceApplication.DTO.OrderEntryDTO;
import com.ladera.SalesForceApplication.model.OrderEntry;
import com.ladera.SalesForceApplication.model.OrderModel;
import com.ladera.SalesForceApplication.model.Product;
import com.ladera.SalesForceApplication.repository.IOrderEntryRepository;
import com.ladera.SalesForceApplication.repository.IOrderRepository;
import com.ladera.SalesForceApplication.repository.ProductRepository;

@Service
public class OrderEntryService {
	@Autowired
	IOrderEntryRepository orderEntryRepository;
	
	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public String createOrderEntry(Integer order_id,Integer product_id, OrderEntryDTO orderEntryDto){
		OrderEntry orderEntry = new OrderEntry();
		BeanUtils.copyProperties(orderEntryDto, orderEntry);
		OrderModel orderModel2 = orderRepository.findById(order_id).get();
		orderEntry.setOrderModel(orderModel2);
		Product product = productRepository.findById(product_id).get();
		orderEntry.setProduct(product);
		double entryTotal=product.getBasePrice()*orderEntry.getQuantity();
		orderEntry.setEntryTotal(entryTotal);
		orderEntryRepository.save(orderEntry);
		return "Order Entry Saved Successfully";
	}
	
	public List<OrderEntry> getOrderEntryForOrder(Integer orderId) {
		OrderModel orderModel = orderRepository.findById(orderId).get();
		List<OrderEntry> orderEntryList = orderEntryRepository.findByOrderModel(orderModel);
		return orderEntryList;
	}
}
