package com.packt.bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

	
	@Id
	private String cust_id;
	private String name;
	private String address;
	private String email;
	private Boolean email_subscribe;
	public Boolean getEmail_subscribe() {
		return email_subscribe;
	}
	public void setEmail_subscribe(Boolean email_subscribe) {
		this.email_subscribe = email_subscribe;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id2) {
		this.cust_id = cust_id2;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String cust_id, String name, String address, String email,
			Boolean email_subscribe) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.email_subscribe = email_subscribe;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", name=" + name + ", address="
				+ address + ", email=" + email + ", email_subscribe="
				+ email_subscribe + "]";
	}
	
	
}
