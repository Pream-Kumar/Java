package com.ladera.SalesForceApplication.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
	private String orderCode;
	private Integer customer_id;
	
	
	
	
	@Override
	public String toString() {
		return "OrderDTO [orderCode=" + orderCode + ", customer_id=" + customer_id + "]";
	}
	
	
	
	
}
