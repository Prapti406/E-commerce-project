package com.product.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.OrderRequest;
import com.product.model.Category;
import com.product.model.Product;
import com.product.service.ProductService;

import lombok.Data;


@Data
@RestController
@RequestMapping("/product")
public class Categorycontroll {
	
	
	private ProductService productservice;
	
	public Categorycontroll(ProductService productservice) {
		super();
		this.productservice = productservice;
	}

	@PostMapping()
	public ResponseEntity<List<Category>>saveProduct(@RequestBody OrderRequest request)
	{
		return new ResponseEntity<List<Category>>(productservice.saveProduct(request.getCategory()),HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Category>getallProduct()
	{
		return productservice.getAllProducts();
	}
	
	@GetMapping("/sortbycategory/incsr")
	public ResponseEntity<List<Category>>sortByCategory(String keyword)
	{
		   return new ResponseEntity<List<Category>>(productservice.incrsdata(keyword),HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("{id}")
	public ResponseEntity<Product>getProductById(@PathVariable("id") long id )
	{
		return new ResponseEntity<Product>(productservice.getProductById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteProduct(@PathVariable("id") long id)
	{
		productservice.deleteProduct(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
	@GetMapping("/categoryname")
	public ResponseEntity<List<Category>>getCategory(@Param("keyword") String keyword)
	{
		return new ResponseEntity<List<Category>>(productservice.findByCategory(keyword),HttpStatus.OK);
	}
	
	@GetMapping("/byname")
	public ResponseEntity<List<Product>>getbyProduct(@Param("keyword") String keyword)
	{
		return new ResponseEntity<List<Product>>(productservice.findByProductName(keyword),HttpStatus.OK);
	}
	
	/*@GetMapping("/get")
	public List<OrderResponse>getJoinInformation()
	{
		return categoryrepo.getJoinInformation();
	}
	*/
	@Value("${server.port}")
    private String port;

    @GetMapping("/info")
    public ResponseEntity<String> showPaymentInfo() {
       return ResponseEntity.ok("FROM PAYMENT SERVICE, Port# is: " + port);
    }
	
}
