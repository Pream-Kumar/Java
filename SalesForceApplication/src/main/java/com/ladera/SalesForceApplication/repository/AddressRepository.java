package com.ladera.SalesForceApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladera.SalesForceApplication.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
