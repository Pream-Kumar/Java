package com.ladera.SalesForceApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladera.SalesForceApplication.model.OrderModel;


@Repository
public interface IOrderRepository extends JpaRepository<OrderModel, Integer>{

//	public OrderModel findByOrderCode(String orderCode);
	
	

}
