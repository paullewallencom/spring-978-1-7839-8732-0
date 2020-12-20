package com.packt.mailservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.core.io.FileSystemResource;  
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.core.task.TaskExecutor;
import javax.mail.Message;  
import java.util.Map;
import java.util.HashMap;
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;
public class MailSenderAsyncService implements MailSender{
 
	    @Resource(name = "mailSender")
	    private MailSender mailSender;
	 
	    private TaskExecutor taskExecutor;
	 
	    @Autowired
	    public MailSenderAsyncService(TaskExecutor taskExecutor) {
	        this.taskExecutor = taskExecutor;
	    }
	 
	    public void send(SimpleMailMessage simpleMessage) throws MailException {
	        taskExecutor.execute(new MailRunnable(simpleMessage));
	    }
	 
	    public void send(SimpleMailMessage[] simpleMessages) throws MailException {
	        for (SimpleMailMessage message : simpleMessages) {
	            send(message);
	        }
	    }
	 
	    private class SimpleMailMessageRunnable implements Runnable {
	 
	        private SimpleMailMessage simpleMailMessage;
	          private SimpleMailMessageRunnable(SimpleMailMessage simpleMailMessage) {
	            this.simpleMailMessage = simpleMailMessage;
	        }
	        
	        public void run() {
	            mailSender.send(simpleMailMessage);
	        }
	    }
	    private class SimpleMailMessagesRunnable implements Runnable {
	   	 
	        private SimpleMailMessage[] simpleMessages;
	          private SimpleMailMessagesRunnable(SimpleMailMessage[] simpleMessages) {
	            this.simpleMessages = simpleMessages;
	        }
	        
	        public void run() {
	            mailSender.send(simpleMessages);
	        }
	    }
	}