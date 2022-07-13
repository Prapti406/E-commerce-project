package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Long>{

}
