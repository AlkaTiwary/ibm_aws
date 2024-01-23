package com.ibm.ex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Orders")
public class Orders {

	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="order_type")
	private String orderType;
	
	@Column(name="order_price")
	private double orderPrice;
	@Column(name="is_Confirmed")
	private boolean isConfirmed;
	
}