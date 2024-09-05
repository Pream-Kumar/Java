package com.ladera.SalesForceApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String productCode;
	private String productName;
	private String description;
	private String productStatus;
	private double basePrice;
	
//
//	@OneToMany(mappedBy = "product")
//	@JsonManagedReference
//	private List<ProductType> productType;
    
//	@OneToOne
//	@JoinColumn(name="pricerow_id")
//	private Pricerow priceRow;
	
	

}
