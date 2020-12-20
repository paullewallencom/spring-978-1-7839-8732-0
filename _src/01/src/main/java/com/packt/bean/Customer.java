package com.packt.bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

	public Customer(String cust_id, String name, String address) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.address = address;
	}
	@Id
	private String cust_id;
	private String name;
	private String address;
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id2) {
		this.cust_id = cust_id2;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", name=" + name + ", address="
				+ address + ", getCust_id()=" + getCust_id() + ", getName()="
				+ getName() + ", getAddress()=" + getAddress()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
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
	
	
}
