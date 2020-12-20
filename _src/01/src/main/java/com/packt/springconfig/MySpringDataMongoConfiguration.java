package com.packt.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
@Configuration
public class MySpringDataMongoConfiguration {
	
	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
	    return new SimpleMongoDbFactory(new Mongo(), "e-shop");
	  }

	  public @Bean MongoTemplate mongoTemplate() throws Exception {
		    return new MongoTemplate(mongoDbFactory());
		  }
}
