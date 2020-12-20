package com.packt.spring4.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;

import com.packt.bean.Customer;
import com.packt.bean.Order;
import com.packt.bean.Product;
import com.packt.jms.OrderSender;
import com.packt.service.CustomerRepository;
import com.packt.service.OrderRepository;
import com.packt.service.ProductRepository;
import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

@Controller
public class OrderController {
	@Autowired
    private OrderSender orderSender;
	@Autowired
	private CustomerRepository customer_respository;
	@Autowired
	private OrderRepository respository;
	@Autowired
	private ProductRepository product_respository;
	private List<Order> orderList;
	private List<Customer> customerList;
	private List<Product> productList;

	public OrderController() {
		super();
	}

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

	@ModelAttribute("customerList")
	public List<Customer> populateCstomerList() {
		this.customerList = customer_respository.getAllObjects();
		return this.customerList;
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	// request show add order page
	public String getaddorder(@ModelAttribute("Order") Order order,
			Map<String, Object> model) {
		model.put("customerList", customerList);
		model.put("productList", productList);
		return "order";
	}

	@RequestMapping(value = "/order/save", method = RequestMethod.POST)
	// request insert order recordh
	public String addorder(@ModelAttribute("Order") Order order,
			Map<String, Object> model) {
		orderSender.sendOrder(order);
		model.put("customerList", customerList);
		model.put("productList", productList);
		return "order";
	}

	@RequestMapping(value = "/order/update", method = RequestMethod.POST)
	public String updatecustomer(@ModelAttribute("Order") Order order,
			Map<String, Object> model) {
		order.setCustomer(customer_respository.getObject(order.getCustomer()
				.getCust_id()));
		order.setProduct(product_respository.getObject(order.getProduct()
				.getProdid()));
		
		respository.updateObject(order);
		model.put("customerList", customerList);
		model.put("productList", productList);
		return "order";
	}

	@RequestMapping(value = "/order/geteditorder", method = RequestMethod.GET)
	public String geteditorder(
			@RequestParam(value = "order_id", required = true) String order_id,
			@ModelAttribute("Order") Order order,
			Map<String, Object> model) {
		model.put("customerList", customerList);
		model.put("productList", productList);
		model.put("Order",respository.getObject(order_id));
		return "editorder";
	}

	@RequestMapping(value = "/order/deleteorder", method = RequestMethod.GET)
	public String deleteorder(
			@RequestParam(value = "order_id", required = true) String order_id,
			@ModelAttribute("Order") Order order,
			Map<String, Object> model) {
		respository.deleteObject(order_id);
		model.put("customerList", customerList);
		model.put("productList", productList);
		return "order";
	}

}
