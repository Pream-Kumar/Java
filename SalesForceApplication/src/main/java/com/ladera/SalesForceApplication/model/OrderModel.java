package com.ladera.SalesForceApplication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class OrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String orderCode;

	@ManyToOne
	@JoinColumn(name = "customerModel")
	@JsonBackReference
	private Customer customer;

	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", orderCode=" + orderCode + ", customer=" + customer + "]";
	}
	
	

}
