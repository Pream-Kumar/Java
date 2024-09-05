package com.ladera.SalesForceApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladera.SalesForceApplication.model.OrderEntry;
import com.ladera.SalesForceApplication.model.OrderModel;

@Repository
public interface IOrderEntryRepository extends JpaRepository<OrderEntry, Integer> {
public List<OrderEntry> findByOrderModel(OrderModel orderModel);
}
