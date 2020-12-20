package com.packt.jms;

import javax.jms.MessageListener;
import javax.jms.Queue;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
@Service  
public class PacktMessageSender {
	private JmsTemplate jmsTemplate;
	private Queue queue;
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}

	public void sendMessage(String msgText) {
		jmsTemplate.convertAndSend(queue, msgText);  

	}
}
