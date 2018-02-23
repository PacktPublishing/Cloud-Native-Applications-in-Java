Feature: get Product 
Get the Product details given a product id 

Scenario: When product id is valid and exists 
The product name and category it belongs to will be returned 
Given product Service is running 
When get product service is called with existing product id 1
Then I should get a response with HTTP status code 200 
And return Product details with name Apples and category 1

Scenario: When product id is invalid or does not exist
An error should be returned 
Given product Service is running 
When get product Service is called with a non existing product id 456
Then return a 404 not found status 
And return error message "No product for id 456" 
