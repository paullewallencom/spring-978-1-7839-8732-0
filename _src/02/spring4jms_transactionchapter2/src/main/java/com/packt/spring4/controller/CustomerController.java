package com.packt.spring4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.packt.bean.Customer;
import com.packt.service.CustomerRepository;


@Controller
public class CustomerController {
	@Autowired
	private CustomerRepository respository;
	private List <Customer>customerList;
	public CustomerController() {
		super();

	}
	@PostConstruct
	public void init(){
		
		this.customerList=respository.getAllObjects();
	}
	@RequestMapping(value="/customer", method = RequestMethod.GET)
	// request show add customer page
	public String getaddcustomer(Model model) {
		this.customerList=respository.getAllObjects();
		model.addAttribute("customerList", customerList);
		model.addAttribute("customerAttribute", new Customer());
		return "customer";
	}

	@RequestMapping(value="/customer/save", method = RequestMethod.POST)
		public String addcustomer(@ModelAttribute Customer cust,Model model) {
		
    		respository.saveObject(cust);
    		System.out.println("Controller");
		this.customerList=respository.getAllObjects();
		model.addAttribute("customerList", customerList);
		return "/customer";  
	}
	
	@RequestMapping(value="/customer/update", method = RequestMethod.POST)
	public String updatecustomer(@ModelAttribute Customer cust,Model model) {
		respository.updateObject(cust);
	this.customerList=respository.getAllObjects();
	model.addAttribute("customerList", customerList);
	return "/customer";  
}
	
	@RequestMapping(value = "/customer/geteditcustomer", method = RequestMethod.GET)
	public String geteditcustomer(
			@RequestParam(value = "cust_id", required = true) String cust_id,
			Model model) {
		this.customerList=respository.getAllObjects();
		model.addAttribute("customerList", customerList);
		model.addAttribute("customerAttribute",respository.getObject(cust_id));
		return "editcustomer";
	}

	@RequestMapping(value = "/customer/getallcustomers", method = RequestMethod.GET)
	public String getallcustomers(Model model) {
		this.customerList=respository.getAllObjects();
		model.addAttribute("customerList", customerList);
		return "allcustomers";
	}
	
	@RequestMapping(value="/customer/deletecustomer", method = RequestMethod.GET)
	public String deletecustomer(
			@RequestParam(value = "cust_id", required = true) String cust_id,
			Model model) {
		respository.deleteObject(cust_id);
		this.customerList=respository.getAllObjects();
		model.addAttribute("customerList", this.customerList);
		return "customer";
	}
	
}
