package com.packt.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.core.io.FileSystemResource;  
import org.springframework.mail.javamail.MimeMessagePreparator;
import javax.mail.Message;  
import java.util.Map;
import java.util.HashMap;
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;
public class MailSenderService {
	@Autowired
	private VelocityEngine velocityEngine;
	@Autowired
	private MailSender mailSender;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired 
	private SimpleMailMessage configured_message;
	public void sendmail(String from, String to, String subject, String body) throws MailException{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom(from);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
	}
	public void sendmail(String from, String []to, String subject, String body) throws MailException{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
	}
	public void sendmime_mail(final String from, final String to, final String subject, final String body) throws MailException{
		MimeMessagePreparator message = new MimeMessagePreparator() {  
               public void prepare(MimeMessage mimeMessage) throws Exception {  
            	   message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));  
            	   message.setFrom(new InternetAddress(from));  
            	   message.setSubject(subject);  
            	   message.setText(msg);  
            }

			public void prepare(MimeMessage arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}

			
    };  
    mailSender.send(message);
	}
	public void sendmail(String from, String []to, String subject, String body,FileSystemResource file,String filename) throws MailException{
		        MimeMessage mimemessage = mailSender.createMimeMessage();  
		        MimeMessageHelper mimemessagehelper = new MimeMessageHelper(message, true);  
		        mimemessagehelper.setFrom(from);  
		        mimemessagehelper.setTo(to);  
		        mimemessagehelper.setSubject(subject);  
		        mimemessagehelper.setText(msg);  
		        mimemessagehelper.addAttachment(filename, file);//image will be sent by this name  
		        mailSender.send(message);  
		       
	}
	public void sendmail(String message) throws MailException{
		SimpleMailMessage message=new SimpleMailMessage(configured_message);
        mailSender.send(message);  
       
}
	public void sendmail(final Customer customer){
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
		      public void prepare(MimeMessage mimeMessage) 
		           throws Exception {
		        MimeMessageHelper message = 
		                              new MimeMessageHelper(mimeMessage);
		        message.setTo(user.getEmailAddress());
	            message.setFrom("webmaster@csonth.gov.uk"); // could be parameterized...
	            Map model = new HashMap();
	            model.put("customer", customer);
	            String text = VelocityEngineUtils.mergeTemplateIntoString(
	               velocityEngine, "com/packt/velocity/templates/orderconfirmation.vm", model);
	            message.setText(text, true);
	         }

			public void prepare(MimeMessage arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}
	      };
	      this.mailSender.send(preparator);
	   }
}
