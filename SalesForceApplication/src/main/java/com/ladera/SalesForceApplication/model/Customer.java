package com.ladera.SalesForceApplication.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String customerId;
	private String name;
	private String contactEmail;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Address> address;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<OrderModel> orders;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerId=" + customerId + ", name=" + name + ", contactEmail=" + contactEmail
				+ ", address=" + address + ", orders=" + orders + "]";
	} 
	
	
}
