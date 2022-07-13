/**
 * 
 */
package com.user.service;

import java.util.List;

import com.user.exception.RecordNotFoundException;
import com.user.model.User;


/**
 * @author ppandey077
 *
 */
public interface AppServiceInt{
	//public List<Product> getAllProducts();
	  
	  public User findUserById(int id)throws RecordNotFoundException;
	  
	  //public Product updateProduct(Product p,long id);
	  
	  //public void deleteProduct(long id);
}
