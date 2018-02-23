package com.mycompany.product.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mycompany.product.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByCatId(int catId);
}
