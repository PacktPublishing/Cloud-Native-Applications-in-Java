package com.mycompany.product.msg;

import com.mycompany.product.entity.Product;

public class ProductUpdMsg {

	Product product ;
	boolean isDelete = false ;
	
	public ProductUpdMsg() {
		
	}
	
	public ProductUpdMsg(Product product, boolean isDelete) {
		this.product = product ;
		this.isDelete = isDelete ;
	}

	public Product getProduct() {
		return product;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}	
}
