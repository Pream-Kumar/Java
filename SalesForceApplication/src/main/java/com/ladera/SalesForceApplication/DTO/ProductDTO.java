package com.ladera.SalesForceApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {
	private int id;
	private String productCode;
	private String description;
	private String productStatus;
	private int quantity;
}
