package com.ladera.SalesForceApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderEntry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer quantity;
	private double entryTotal;
	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonIgnore
	private OrderModel orderModel;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
}
