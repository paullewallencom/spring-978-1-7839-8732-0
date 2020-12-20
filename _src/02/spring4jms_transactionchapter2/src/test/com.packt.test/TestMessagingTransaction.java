package com.packt.test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"E:\PACKT_WORKSPACE\Spring4JMS_TransactionChapter2\src\main\webapp\WEB-INF\dispatcher-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMessagingTransaction extends TestMessagingMongoDB{
	@Test
	public void testCorrectMessage() throws InterruptedException {
		Order order = new Order(0, "notification to deliver correctly");
		ordersender.convertAndSendMessage(QUEUE_INCOMING, notification);
		
		Thread.sleep(6000);
		printResults();
		
		assertEquals(1, getSavedOrders());
		assertEquals(0, getMessagesInQueue(QUEUE_INCOMING));
		assertEquals(0, getMessagesInQueue(QUEUE_DLQ));
	}
	
	/**
	 * Tests a failure after receiving the message and before saving it to the DB
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testFailedAfterReceiveMessage() throws InterruptedException {
		Order order = new Order(1, "ordernotification to fail after receiving");
		ordersender.convertAndSendMessage(QUEUE_INCOMING, order);
		
		Thread.sleep(6000);
		printResults();
		
		assertEquals(0, getSavedOrders());
		assertEquals(0, getMessagesInQueue(QUEUE_INCOMING));
		assertEquals(1, getMessagesInQueue(QUEUE_DLQ));
		//Empty the dead letter queue
		jmsTemplate.receive(QUEUE_DLQ);
	}
	
	@Test
	public void testFailedAfterProcessingMessage() throws InterruptedException {
		Order order = new Order(2, "ordernotification to fail after processing");
		ordersender.convertAndSendMessage(QUEUE_INCOMING, order);
		Thread.sleep(6000);
		printResults();
		assertEquals(2, getSavedOrders());
		assertEquals(0, getMessagesInQueue(QUEUE_INCOMING));
		assertEquals(0, getMessagesInQueue(QUEUE_DLQ));
	}
	
	private void printResults() {
		logger.info("Total items in \"incoming\" queue: "+getMessagesInQueue(QUEUE_INCOMING));
		logger.info("Total items in \"dead letter\" queue: "+getMessagesInQueue(QUEUE_DLQ));
		logger.info("Total items in DB: "+getSavedOrders());
	}
}
