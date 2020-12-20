package com.packt.test;

import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.QueueBrowser;
import javax.jms.Session;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.BrowserCallback;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.packt.jms.OrderSender;
import com.packt.service.OrderRepository;
@ContextConfiguration(locations = {"E:\PACKT_WORKSPACE\Spring4JMS_TransactionChapter2\src\main\webapp\WEB-INF\dispatcher-servlet.xml"})
@DirtiesContext
public class TestMessagingMongoDB {
protected static final String QUEUE_INCOMING = "orderQueue";
	protected static final String QUEUE_DLQ = "ActiveMQ.DLQ";

	@Autowired
	protected OrderRepository orderRepository;
	
	@Autowired
	protected JmsTemplate jmsTemplate;
	
	@Autowired
	protected OrderSender ordersender;
	
	
	@Before
	public void prepareTest() {
		orderRepository.dropCollection();
	}

	protected List getOrders() {
		return orderRepository.getAllObjects();
	}
	

	protected int getMessagesInQueue(String queueName) {
		return jmsTemplate.browse(queueName, new BrowserCallback<Integer>() {
			@Override
			public Integer doInJms(Session session, QueueBrowser browser) throws JMSException {
				Enumeration<?> messages = browser.getEnumeration();
				int total = 0;
				while (messages.hasMoreElements()) {
					messages.nextElement();
					total++;
				}

				return total;
			}
		});
	}
}
