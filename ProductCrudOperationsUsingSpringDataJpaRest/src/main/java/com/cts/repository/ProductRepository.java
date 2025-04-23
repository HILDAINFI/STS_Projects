package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
//	public abstract String saveProduct(Product product);//save
//
//	public abstract String updateProduct(Product product);//save
//
//	public abstract String removeProduct(int productId);//deleteById
//
//	public abstract Product getProduct(int productId);//findById
//
//	public abstract List<Product> getAllProducts();//findAll

	public abstract List<Product> findByProductPriceBetween(int initialPrice, int finalPrice);
	 
	public abstract List<Product> findByProductCategory(String category);

	List<Product> findByProductPriceGreaterThan(int price);

}
