package com.mycompany.product.dao;

import com.mycompany.product.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findByCatId(int catId);
	
}
