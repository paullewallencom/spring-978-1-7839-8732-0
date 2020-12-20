package com.packt.service;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.packt.bean.Customer;
import com.packt.bean.Product;
@Repository
public class ProductRepository {
	@Autowired
	MongoTemplate mongoTemplate;
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<Product> getAllObjects() {
		return mongoTemplate.findAll(Product.class);
	}

	/**
	 * Saves a {@link Product}.
	 */
	public void saveObject(Product Product) {
		Product.setProdid(UUID.randomUUID().toString());
		mongoTemplate.insert(Product);
	}

	/**
	 * Gets a {@link Product} for a particular id.
	 */
	public Product getObject(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)),
				Product.class);
	}

	/**
	 * Updates a {@link Product} name for a particular id.
	 */
	public void updateObject(Product object) {
				Query query = new Query();
				query.addCriteria(Criteria.where("_id").is(object.getProdid()));
				Product prod_tempObj = mongoTemplate.findOne(query, Product.class);
			 		System.out.println("cust_tempObj - " + prod_tempObj);
				//modify and update with save()
			 		prod_tempObj.setName(object.getName());
			 		prod_tempObj.setPrice(object.getPrice());
				mongoTemplate.save(prod_tempObj);
	}

	/**
	 * Delete a {@link Product} for a particular id.
	 */
	public void deleteObject(String id) {
		mongoTemplate
				.remove(new Query(Criteria.where("_id").is(id)), Product.class);
	}

	/**
	 * Create a {@link Product} collection if the collection does not already
	 * exists
	 */
	public void createCollection() {
		if (!mongoTemplate.collectionExists(Product.class)) {
			mongoTemplate.createCollection(Product.class);
		}
	}

	/**
	 * Drops the {@link Product} collection if the collection does already exists
	 */
	public void dropCollection() {
		if (mongoTemplate.collectionExists(Product.class)) {
			mongoTemplate.dropCollection(Product.class);
		}
	}

}