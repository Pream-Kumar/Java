package com.ladera.SalesForceApplication.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderEntryDTO {
	private Integer quantity;
	private Integer order_id;
	private Integer product_id;
}
