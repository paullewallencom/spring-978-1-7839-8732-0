package com.packt.jms;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.packt.bean.Customer;
import com.packt.bean.Order;
import com.packt.bean.Product;
import com.packt.service.CustomerRepository;
import com.packt.service.OrderRepository;
import com.packt.service.ProductRepository;

@Component
public class OrderReceiver {
	@Autowired
	private CustomerRepository customer_respository;
	@Autowired
	private OrderRepository respository;
	@Autowired
	private ProductRepository product_respository;
    public void orderReceived(Map<String, Object>  mapMessage) throws Exception {
    	Customer cust=customer_respository.getObject(mapMessage.get("customerId").toString());
    	Product prod=product_respository.getObject(mapMessage.get("productId").toString());
       	Order order=new Order(null, cust, prod,null, "pending", (Integer) mapMessage.get("quantity"));
    	   respository.saveObject(order);
      }
}
