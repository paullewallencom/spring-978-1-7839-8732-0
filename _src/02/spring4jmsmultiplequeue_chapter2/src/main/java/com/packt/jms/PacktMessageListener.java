package com.packt.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class PacktMessageListener implements MessageListener {
	private PacktMessageSender packtmessagesender;

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				String msgText = ((TextMessage) message).getText();
				System.out.println("start the message process:"+msgText);
				packtmessagesender.sendMessage(msgText);

			} catch (JMSException jmsexception) {
				System.out.println(jmsexception.getMessage());

			}
		} else {

			throw new RuntimeException("exception runtime");
		}
	}
	public void setTestMessageSender(PacktMessageSender packtmessagesender) {
		this.packtmessagesender = packtmessagesender;
	}
	public PacktMessageSender getPacktmessagesender() {
		return packtmessagesender;
	}
	public void setPacktmessagesender(PacktMessageSender packtmessagesender) {
		this.packtmessagesender = packtmessagesender;
	}

}
