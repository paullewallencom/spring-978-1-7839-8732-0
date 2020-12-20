package com.packt.bean;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	private String prodid;
	private Double price;
	private String name;
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prod_id) {
		this.prodid = prod_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
}
