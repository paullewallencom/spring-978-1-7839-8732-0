package com.packt.service;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.packt.bean.Customer;


@Repository

public class CustomerRepository {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<Customer> getAllObjects() {
		return mongoTemplate.findAll(Customer.class);
	}
	
	
	public void saveObject(Customer customer) {
		customer.setCust_id(UUID.randomUUID().toString());
		
		mongoTemplate.insert(customer);
	}


	public Customer getObject(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)),
				Customer.class);
	}

	
	public void deleteObject(String id) {
		mongoTemplate
				.remove(new Query(Criteria.where("_id").is(id)), Customer.class);
	}

	/**
	 * Create a {@link Customer} collection if the collection does not already
	 * exists
	 */
	public void createCollection() {
		if (!mongoTemplate.collectionExists(Customer.class)) {
			mongoTemplate.createCollection(Customer.class);
		}
		
		


	}

	/**
	 * Drops the {@link Customer} collection if the collection does already exists
	 */
	public void dropCollection() {
		if (mongoTemplate.collectionExists(Customer.class)) {
			mongoTemplate.dropCollection(Customer.class);
		}
	}

	public void updateObject(Customer object) {
			Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(object.getCust_id()));
		Customer cust_tempObj = mongoTemplate.findOne(query, Customer.class);
	 		System.out.println("cust_tempObj - " + cust_tempObj);
		//modify and update with save()
		cust_tempObj.setName(object.getName());
		cust_tempObj.setAddress(object.getAddress());
		mongoTemplate.save(cust_tempObj);
			}

	
}