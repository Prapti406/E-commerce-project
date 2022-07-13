package com.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.model.CartItems;

public interface CartItemsRepository extends JpaRepository<CartItems, Long>{

}
