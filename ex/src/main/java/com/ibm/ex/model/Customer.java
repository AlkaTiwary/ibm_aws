package com.ibm.ex.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ibm.ex.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customer")


public class Customer {
	
	@Id
	@Column(name="customer_id")
	private String customerId;
	@Column(name = "customer_name")
	private String customerName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_Orderid")
	private Orders orders;
	public Customer(String customerId,String customerName) {
		super();
		this.customerId = customerId;

		this.customerName = customerName;
	}
}
