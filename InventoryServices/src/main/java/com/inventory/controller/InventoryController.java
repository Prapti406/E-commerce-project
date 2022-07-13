package com.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.inventory.exception.ResourceNotFoundException;
import com.inventory.model.Inventory;
import com.inventory.repository.InventoryRepo;
import com.inventory.services.ServiceFeign;


@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	ServiceFeign service;
	@Autowired
	InventoryRepo irepo;
	
	
			//get inventory status by product id
			@GetMapping("/inventorystatus/{pid}")
			public Inventory InventoryStatus(@PathVariable("pid")long id) throws ResourceNotFoundException {
				Optional<Inventory> op= service.findProduct(id);
				if(op.isPresent())
				{
					return irepo.save(op.get());
				}
				else
				{
					throw new ResourceNotFoundException("Product not found with id:"+id);
				}
				
						
			}
			//update inventory stock by product id
			@PutMapping("/updateinventorystock/{pid}")
			public Inventory updateInventoryStock(@RequestBody Inventory inv, @PathVariable("pid")long id ) throws ResourceNotFoundException {
				Optional<Inventory> op= service.updateUser(inv, id);
				if(op.isPresent())
				{
					return irepo.save(op.get());
				}
				else
				{
					throw new ResourceNotFoundException("Product not found with id:"+id);
				}
				//return service.updateUser(inv, id);
				
			}
			@Value("${server.port}")
		    private String port;

		    @GetMapping("/info")
		    public ResponseEntity<String> showPaymentInfo() {
		       return ResponseEntity.ok("FROM User SERVICE, Port# is: " + port);
		    }
			}
