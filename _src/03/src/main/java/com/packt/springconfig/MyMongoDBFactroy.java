package com.packt.springconfig;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MyMongoDBFactroy {
private static Mongo mongo;
	
	private MyMongoDBFactroy() {}
	
	public static Mongo getMongo() {
				if (mongo == null) {
			try {
				mongo = new Mongo( "localhost" , 27017 );
			} catch (UnknownHostException e) {
				System.out.println(e.getMessage());
			} catch (MongoException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return mongo;
	}
	
	public static DB getDB(String dbname) {
		System.out.println("Retrieving db: " + dbname);
		return getMongo().getDB(dbname);
	}
	
	public static DBCollection getCollection(String dbname, String collection) {
		System.out.println("Retrieving collection: " + collection);
		return getDB(dbname).getCollection(collection);
	}

}

