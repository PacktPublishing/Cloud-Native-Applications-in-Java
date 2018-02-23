package com.mycompany.product;

import com.mycompany.product.entity.Product;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceTest {

  @Autowired
  TestRestTemplate restTemplate;

  @Test
  public void getProduct() {
    ResponseEntity<Product> response = restTemplate.getForEntity("/product/1", Product.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Apples", response.getBody().getName());
  }

  @Test
  public void getProductsForCategory() {
    ResponseEntity<Object[]> response = restTemplate.getForEntity("/products?id=1", Object[].class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertFalse(response.getBody().length == 0);
  }

}