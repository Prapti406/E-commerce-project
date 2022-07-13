package com.product.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product_tab")
@Getter
@Setter
public class Product {

	@Id
	@Column(name="product_id")
	private long id;
	@Column(name="product_price")
	private String  productPrice;
	@Column(name="brand_name")
	private String brandName;
	@Column(name="product_desc")
	private String productDesc;
	
}
