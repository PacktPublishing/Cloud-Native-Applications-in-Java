package com.mycompany.product;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mycompany.product.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestSuite {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test() {
		 ResponseEntity<Product> response = this.restTemplate.getForEntity("/product/1", Product.class, new HashMap<>());
	        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	        Assert.assertEquals("Apples", response.getBody().getName());
	        
	}
}
