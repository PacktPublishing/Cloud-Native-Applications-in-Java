package com.mycompany.product.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findByCatId(int catId);
	
}
