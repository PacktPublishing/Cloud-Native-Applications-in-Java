package com.mycompany.product;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductService {

	@RequestMapping("/product/{id}")
	Product getProduct(@PathVariable("id") int id) {
		return new Product(id);
	}

	@RequestMapping("/productIds")
	List<Integer> getProductIds(@RequestParam("id") int id) {
		return Arrays.asList(id + 1, id + 2, id + 3);
	}
}
