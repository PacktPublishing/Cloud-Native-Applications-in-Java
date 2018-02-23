package com.mycompany.product;


import java.util.HashMap;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.mycompany.product.entity.Product;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CucumberTestSteps {
 
    @Autowired
    private TestRestTemplate restTemplate;
 
    private ResponseEntity<Product> productResponse;
    private ResponseEntity<String> errResponse;
 
    @Given("(.*) Service is running")
    public void checkServiceRunning(String serviceName) {
    	ResponseEntity<String> healthResponse = restTemplate.getForEntity("/health",String.class, new HashMap<>());
    	Assert.assertEquals(HttpStatus.OK, healthResponse.getStatusCode());
    }
 
    @When("get (.*) service is called with existing product id (\\d+)$")
    public void callService(String serviceName, int prodId) throws Throwable {
    	productResponse = this.restTemplate.getForEntity("/"+serviceName+"/" + prodId, Product.class, new HashMap<>());
    }
 
    @Then("I should get a response with HTTP status code (.*)")
    public void shouldGetResponseWithHttpStatusCode(int statusCode) {
    	Assert.assertEquals(statusCode, productResponse.getStatusCodeValue());
    }
    
    @And("return Product details with name (.*) and category (\\d+)$")
    public void theResponseShouldContainTheMessage(String prodName, int categoryId) {
    	Product product = productResponse.getBody() ;
    	Assert.assertEquals(prodName, product.getName());
    	Assert.assertEquals(categoryId, product.getCatId());      
    }
    
    @When("^get (.*) Service is called with a non existing product id (\\d+)$")
    public void get_Product_Service_is_called_with_a_non_existing_product_id(String serviceName, int prodId) throws Throwable {
    	errResponse = this.restTemplate.getForEntity("/"+serviceName+"/" + prodId, String.class, new HashMap<>());
    }

    @Then("^return a (\\d+) not found status$")
    public void return_a_status(int status) throws Throwable {
    	Assert.assertEquals(HttpStatus.NOT_FOUND, errResponse.getStatusCode());
    }

    @Then("^return error message \"(.*)\"$")
    public void return_error_message_indicating_product_is_not_found(String errMsg) throws Throwable {
    	Assert.assertTrue(errResponse.getBody().contains(errMsg));
    }
}