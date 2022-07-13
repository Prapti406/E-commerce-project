package com.product.repository;


import java.util.List;
import java.util.Optional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.product.model.Product;



@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product, Long> {


	
	
	@Query("SELECT p FROM Product p WHERE p.brandName LIKE %?1%"
            + " OR p.productDesc LIKE %?1%"
            + " OR CONCAT(p.productPrice, '') LIKE %?1% ")
	//@Query ("SELECT Category.categoryid,Category.productType,Product.id,Product.productPrice,Product.productDesc FROM Category INNER JOIN Product ON Category.categoryid=Product.cat_fk")
	
	/*<named-query name="User.findByLastname">
	  <query>select u from User u where u.lastname = ?1</query>
	</named-query>*/
	List<Product> search(String keyword);
	//@NamedQueries({
	//@Query ("SELECT Product.id FROM Category INNER JOIN  Product ON Category.categoryid=Product.cat_fk")
	

}
