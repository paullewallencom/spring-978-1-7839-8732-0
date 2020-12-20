package com.packt.bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	private String order_id;
	private Customer customer;
	private Product product;
	private String date;
	private String order_status;
	private int quantity;
	
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Id
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String order_id, Customer customer, Product product,
			String date, String order_status, int quantity) {
		super();
		this.order_id = order_id;
		this.customer = customer;
		this.product = product;
		this.date = date;
		this.order_status = order_status;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer=" + customer
				+ ", product=" + product + ", date=" + date + ", order_status="
				+ order_status + ", quantity=" + quantity + ", getCustomer()="
				+ getCustomer() + ", getProduct()=" + getProduct()
				+ ", getOrder_id()=" + getOrder_id() + ", getDate()="
				+ getDate() + ", getQuantity()=" + getQuantity()
				+ ", getOrder_status()=" + getOrder_status() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
