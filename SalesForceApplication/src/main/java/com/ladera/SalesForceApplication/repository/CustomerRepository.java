package com.ladera.SalesForceApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladera.SalesForceApplication.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
