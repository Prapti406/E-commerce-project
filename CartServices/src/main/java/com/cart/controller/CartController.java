package com.cart.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cart.model.Cart;
import com.cart.repository.CartRepository;

import com.cart.dto.CartDto;
import com.cart.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartRepository crepo;
	
    
	//load cart items
	@GetMapping("/loaditemsincart")
	public List <Cart> GetItems(){
		List<Cart> lst=crepo.findAll();
		return lst;
		
	}
	//add product to cart
	@PostMapping("/addproduct")
	public Cart AddProduct(@RequestBody CartDto reg) {
		return crepo.save(reg.getCart());
			}
	//update items quantity in cartitem
	@PutMapping("/updateitems/{id}")
	public Cart UpdateItems(@RequestBody Cart cartitem,@PathVariable ("id") long id){
		Cart ocartitem= crepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found with id:"+id)); 
		ocartitem.setCartitems(cartitem.getCartitems());
		return crepo.save(ocartitem);
		}
	//remove items from cart
	@DeleteMapping("/removeitems/{id}")
	public ResponseEntity<Cart> RemoveItems(@PathVariable("id") long id){
			Cart ocart= crepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Item not found with id:"+ id));
            crepo.delete(ocart);
			return ResponseEntity.ok().build();
		}
	@Value("${server.port}")
    private String port;

    @GetMapping("/info")
    public ResponseEntity<String> showPaymentInfo() {
       return ResponseEntity.ok("FROM User SERVICE, Port# is: " + port);
    }
	}
	



