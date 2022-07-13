package com.product.service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.product.model.Category;
import com.product.model.Product;
import com.product.repository.CategoryRepo;
import com.product.repository.ProductRepo;



@Service
public class ProductServiceImpl  implements ProductService{

	
	private CategoryRepo categoryrepo;
	private ProductRepo productrepo;
	
	public ProductServiceImpl(CategoryRepo categoryrepo,ProductRepo productrepo) {
		super();
		this.categoryrepo = categoryrepo;
		this.productrepo=productrepo;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List< Category> saveProduct(Category category) {
		// TODO Auto-generated method stub
		return (List<Category>) categoryrepo.save(category);
	}

	@Override
	public List<Category> getAllProducts() {
		// TODO Auto-generated method stub
		return categoryrepo.findAll();
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		Optional<Product>op=productrepo.findById(id);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		Optional<Category>op=categoryrepo.findById(id);
				if(op.isPresent())
				{
					categoryrepo.deleteById(null);
				}
		
	}
	@Override
	public List<Category> findByCategory(String keyword) {
		// TODO Auto-generated method stub
		if(keyword!=null)
		{
			return categoryrepo.search(keyword);
		}
		return null;
	}

	@Override
	public List<Product> findByProductName(String keyword) {
		// TODO Auto-generated method stub
		if(keyword!=null)
		{
			return productrepo.search(keyword);
		}
		return null;
	}

	@Override
	public Category categoryid(long id) {
		// TODO Auto-generated method stub
		Optional<Category>op=categoryrepo.findById(id);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public List<Category> incrsdata(String keyword) {
		// TODO Auto-generated method stub
		List<Category>ct=categoryrepo.findAll(Sort.by(Sort.Direction.ASC,"productPrice"));
		return ct;
	}
}
