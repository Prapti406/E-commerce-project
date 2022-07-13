package com.product.repository;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.product.model.Category;



@Repository
@EnableJpaRepositories
public interface CategoryRepo extends JpaRepository<Category, Long> {

	@Query("SELECT  c from Category c where c.productType LIKE %?1%")
	
	
	List<Category> search(String keyword);

	


}
