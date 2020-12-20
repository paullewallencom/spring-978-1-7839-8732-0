package com.packt.service;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
@Repository
public interface MyMongoRepository<T> {
		public List<T> getAllObjects();
		public void saveObject(T object);
		public T getObject(Integer id);
		public WriteResult updateObject(T object);
		public void deleteObject(Integer id);
		public void createCollection();
		public void dropCollection();
	}

