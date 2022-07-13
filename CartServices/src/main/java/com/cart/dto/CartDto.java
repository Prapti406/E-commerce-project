package com.cart.dto;

import com.cart.model.Cart;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data 
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartDto {
	private Cart cart;

}
