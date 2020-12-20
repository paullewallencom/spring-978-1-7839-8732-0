package com.packt.spring4.controller;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.bean.Customer;
import com.packt.bean.Product;
import com.packt.service.ProductRepository;
@Controller
public class ProductController {

	@Autowired
	private ProductRepository respository;
	private List <Product>productList;
	public ProductController() {
		super();
	}
	@PostConstruct
	public void init(){
		this.productList=respository.getAllObjects();
	}
	@RequestMapping(value="/product", method = RequestMethod.GET)
		public String getaddproduct(Model model) {

		model.addAttribute("productList", productList);
		model.addAttribute("productAttribute", new Product());
		return "product";
	}
	@RequestMapping(value="/product/save", method = RequestMethod.POST)
	public String addproduct(@ModelAttribute Product prod,Model model) {
		if(StringUtils.hasText(prod.getProdid())) {
			respository.updateObject(prod);
    	} else {
    		respository.saveObject(prod);
        	}
		this.productList=respository.getAllObjects();
		model.addAttribute("productList", productList);
		return "product";  
	}
	@RequestMapping(value="/product/update", method = RequestMethod.POST)
	public String updatecustomer(@ModelAttribute Product prod,Model model) {
		respository.updateObject(prod);
	this.productList=respository.getAllObjects();
	model.addAttribute("productList", productList);
	return "product";  
}
	@RequestMapping(value = "/product/geteditproduct", method = RequestMethod.GET)
	public String geteditproduct(
			@RequestParam(value = "prodid", required = true) String prodid,
			Model model) {
		model.addAttribute("productList", productList);
		model.addAttribute("productAttribute",respository.getObject(prodid));
		return "editproduct";
	}
	@RequestMapping(value="/product/deleteproduct", method = RequestMethod.GET)
	public String deleteproduct(
			@RequestParam(value = "prodid", required = true) String prodid,
			Model model) {
		respository.deleteObject(prodid);
		this.productList=respository.getAllObjects();
		model.addAttribute("productList", this.productList);
		return "product";
	}
	@RequestMapping(value = "/product/getallproducts", method = RequestMethod.GET)
	public String getallproducts(Model model) {
		this.productList=respository.getAllObjects();
		model.addAttribute("productList", this.productList);
		return "allproducts";
	}
	
}
