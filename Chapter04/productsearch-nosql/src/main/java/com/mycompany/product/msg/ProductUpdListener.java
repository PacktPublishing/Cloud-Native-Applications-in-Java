package com.mycompany.product.msg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;

import com.mycompany.product.ProductService;
import com.mycompany.product.entity.Product;

@Component
public class ProductUpdListener {

	@Autowired
	ProductService prodService ;
	
	@JmsListener(destination = "${jms.ProductTopic}", subscription = "productSearchListener")
	public void receiveMessage(ProductUpdMsg msg) {

		Product product = msg.getProduct() ;
		boolean isDelete = msg.isDelete() ;
		if (isDelete) {
			prodService.deleteProduct(product);
			System.out.println("deleted " + product.getId());
		} else {
			prodService.insertUpdateProduct(product);		
			System.out.println("upserted " + product.getId());
		}
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.BYTES);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
}
