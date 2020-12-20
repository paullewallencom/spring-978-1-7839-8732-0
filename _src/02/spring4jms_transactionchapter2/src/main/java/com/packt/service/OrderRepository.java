package com.packt.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.mongodb.WriteResult;
import com.packt.bean.Customer;
import com.packt.bean.Order;

@Repository
public class OrderRepository {
	@Autowired
	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<Order> getAllObjects() {
		return mongoTemplate.findAll(Order.class);
	}

	/**
	 * Saves a {@link Order}.
	 */
	public void saveObject(Order Order) {

		Order.setOrder_id(UUID.randomUUID().toString());
		mongoTemplate.insert(Order);
	}

	/**
	 * Gets a {@link Order} for a particular id.
	 */
	public Order getObject(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)),
				Order.class);
	}


	public void updateObject(Order object) {
		Query query = new Query();
	query.addCriteria(Criteria.where("_id").is(object.getOrder_id()));
	Order order_tempObj = mongoTemplate.findOne(query, Order.class);
 		System.out.println("order_tempObj - " + order_tempObj);
 		order_tempObj.setCustomer(object.getCustomer());
 		order_tempObj.setProduct(object.getProduct());
 		order_tempObj.setQuantity(object.getQuantity());
 		mongoTemplate.save(order_tempObj);
		}

	/**
	 * Delete a {@link Order} for a particular id.
	 */
	public void deleteObject(String id) {
		mongoTemplate.remove(new Query(Criteria.where("_id").is(id)),
				Order.class);
	}

	/**
	 * Create a {@link Order} collection if the collection does not already
	 * exists
	 */
	public void createCollection() {
		if (!mongoTemplate.collectionExists(Order.class)) {
			mongoTemplate.createCollection(Order.class);
		}
	}

	/**
	 * Drops the {@link Order} collection if the collection does already exists
	 */
	public void dropCollection() {
		if (mongoTemplate.collectionExists(Order.class)) {
			mongoTemplate.dropCollection(Order.class);
		}
	}
}