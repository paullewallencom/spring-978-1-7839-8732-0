package com.packt.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.packt.bean.Order;


public class OrderSender {
    
    @Autowired
    private JmsTemplate jmsTemplate;
    public void sendOrder(final Order order){
        jmsTemplate.send(
        new MessageCreator() {
          public Message createMessage(Session session) throws JMSException {
        	  MapMessage mapMessage = session.createMapMessage();
        	  mapMessage.setInt("quantity", order.getQuantity());
              mapMessage.setString("customerId", order.getCustomer().getCust_id());
              mapMessage.setString("productId", order.getProduct().getProdid());
               return mapMessage;
               
          }
        }
        );
        System.out.println("Order: "+ order);
    }
}
  