package com.mycompany.product.entity ;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	
	@Column(nullable = false)
	private String name ;
	
	@Column(nullable = false)
	private int catId ;

	public Product() {
		
	}
	
	public Product(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getId() {
		return id;
	}

}
