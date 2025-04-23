
package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Product;
import com.cts.service.ProductService;
 
@RestController
@RequestMapping("/products") // http://localhost:1111/products
public class ProductController {
	@Autowired
	ProductService service;
 
	@GetMapping("/getMsg") // http://localhost:1111/products/getMsg
	public String sayHello() {
		return "Account saved successfully";
	}
 
	@PostMapping("/saveproduct") // http://localhost:1111/products/saveproduct
	public Product insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}
	@PutMapping("/updateaccount") // http://localhost:1111/products/saveproduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@GetMapping("/getaccount/{pid}") // http://localhost:1111/products/getproduct
	public Product getProduct(@PathVariable("pid") int productId) {
		return service.getProduct(productId);
	}
	
	@DeleteMapping("/removeproduct/{pid}") // http://localhost:1111/products/getproduct
	public String removeProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}
	
	@GetMapping("/getallproduct") // http://localhost:1111/products/getproduct
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/getallproductbetween/{price1}/{price2}") // http://localhost:1111/products/getproduct
	public List<Product>getAllProductsBetween(@PathVariable("price1")int initialPrice ,@PathVariable("price2")int finalPrice) {
		return service.getAllProductsBetween( 200,  1000);
	}
	
	@GetMapping("/getallproductsbycategory/{category}")
	public List<Product>getAllProductsByCategory(@PathVariable("category")String category) {
		return service.getAllProductsByCategory(category);
	}
}
 
 