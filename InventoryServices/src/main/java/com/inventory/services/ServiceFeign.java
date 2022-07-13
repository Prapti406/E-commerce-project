package com.inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.inventory.model.Inventory;



@FeignClient(name="PRODUCT-SERVICE",url="http://localhost:8080/product")
public interface ServiceFeign {
	

		//get inventory status by product id
		@GetMapping("/findproduct/{pid}")
		public Optional<Inventory> findProduct(@PathVariable("pid")long id);
		
		//update inventory status by product id
		@PutMapping("/updateproduct/{pid}")
		public Optional<Inventory> updateUser(@RequestBody  Inventory inventory, @PathVariable("pid") long id);
		
	
}
