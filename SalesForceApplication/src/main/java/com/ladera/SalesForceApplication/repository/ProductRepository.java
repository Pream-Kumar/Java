package com.ladera.SalesForceApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladera.SalesForceApplication.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
