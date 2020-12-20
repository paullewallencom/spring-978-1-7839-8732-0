package com.packt.spring4.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.packt.bean.Customer;
import com.packt.bean.Order;
import com.packt.bean.Product;
import com.packt.mailservice.MailSenderService;
import com.packt.service.CustomerRepository;
import com.packt.service.OrderRepository;
import com.packt.service.ProductRepository;

public class PromotionsController {
	@Autowired
	private OrderRepository respository;
	@Autowired
	private CustomerRepository customer_respository;
	@Autowired
	private ProductRepository product_respository;
	@Autowired
	private MailSenderService mailSenderService ;
	private List<Order> orderList;
	private List<Customer> subscribe_customerList;
	private List<Product> productList;

	

	@ModelAttribute("orderList")
	public List<Order> populateOrderList() {
		this.orderList = respository.getAllObjects();
		return this.orderList;
	}

	@ModelAttribute("productList")
	public List<Product> populateProductList() {
		this.productList = product_respository.getAllObjects();
		return this.productList;
	}

	@ModelAttribute("subscribe_customerList")
	public List<Customer> populate_subscribedCustomers() {
		this.subscribe_customerList = customer_respository.getAllObjectsby_emailsubscription("yes");
		return this.subscribe_customerList;
	}
	@RequestMapping(value = "/promotions/sendProductPromotions", method = RequestMethod.POST)
	// request insert order recordh
	public String sendProductPromotions() {
		Customer [] subscribers = subscribe_customerList.toArray(new Customer[list.size()]);
		mailSenderService.sendmail("eshop@gmail.com",subscribers,
				"Dear Customers",productList);
		return "promotions";
	}
}
