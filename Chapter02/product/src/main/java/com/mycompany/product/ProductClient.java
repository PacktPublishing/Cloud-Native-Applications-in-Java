package com.mycompany.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductClient {

	@Autowired
	private RestTemplate rTemplate ;
	
	@Value("${env}")
	private String env ; 
	
	@RequestMapping("/client/{id}")
	Product getProduct(@PathVariable("id") int id) {
		
		Product product = rTemplate.getForObject(
				"http://PRODUCT/" + env +"/product/" + id, 
				Product.class);
		return product ;
	}

}
