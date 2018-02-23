package com.mycompany.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.product.dao.ProductRepository;
import com.mycompany.product.entity.Product;
import com.mycompany.product.exception.BadRequestException;

@RestController
public class ProductService {

	@Autowired
	ProductRepository prodRepo ;
	
	@RequestMapping(value="/product/{id}", method = RequestMethod.GET )
	Product getProduct(@PathVariable("id") int id) {
		Product prod = prodRepo.findOne(id);
		if (prod == null)
			throw new BadRequestException(BadRequestException.ID_NOT_FOUND, "No product for id " + id) ;
		else
			return prod ;
	}
	
	@RequestMapping("/products")
	List<Product> getProductsForCategory(@RequestParam("id") int id) {
		return prodRepo.findByCatId(id);
	}
	
	@RequestMapping(value="/product/{id}", method = RequestMethod.PUT)
	Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		
		// First fetch an existing product and then modify it. 
		Product existingProduct = prodRepo.findOne(id); 
		if (existingProduct == null) {
			String errMsg = "Product Not found with code " + id ;
			throw new BadRequestException(BadRequestException.ID_NOT_FOUND, errMsg);
		}
		
		// Now update it back 
		existingProduct.setCatId(product.getCatId());
		existingProduct.setName(product.getName());
		Product savedProduct = prodRepo.save(existingProduct) ;
		
		// Return the updated product  
		return savedProduct ; 		
	}
	
	@RequestMapping(value="/product", method = RequestMethod.POST)
	Product insertProduct(@RequestBody Product product) {
		
		Product savedProduct = prodRepo.save(product) ;
		return savedProduct ;		
	}
	
	
	@RequestMapping(value="/product/{id}", method = RequestMethod.DELETE)
	Product deleteProduct(@PathVariable("id") int id) {
		
		// First fetch an existing product and then delete it. 
		Product existingProduct = prodRepo.findOne(id); 
		if (existingProduct == null) {
			String errMsg = "Product Not found with code " + id ;			
			throw new BadRequestException(BadRequestException.ID_NOT_FOUND, errMsg);
		}
		
		// Return the deleted product 
		prodRepo.delete(existingProduct);
		return existingProduct ;		
	}
}
