package org.h4q.h4q_database_manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.bson.BsonDocument;
import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Sorts.*;

public class DataBaseClient {

	MongoClient client;
    MongoDatabase db;
    Properties configuration;
    
    public DataBaseClient() throws IOException{
    	configuration = new Properties();
    	//Go to src/main/resources/dataBaseConfiguration.properties
    	//   for change the configuration
    	FileInputStream properties = new FileInputStream(new File("src/main/resources/dataBaseConfiguration.properties"));
    	configuration.load(properties);
    	client = new MongoClient(configuration.getProperty("host")+":"+configuration.getProperty("port"));
    	db = client.getDatabase(configuration.getProperty("dataBase"));
    }
    
    /**
     * Save de report on client collection 
     * @param client collection name
     * @param report report to save
     */
    public Document saveReport(String client, String report){
    	Document document = Document.parse("{reporte:"+report+"}");
        db.getCollection(client).insertOne(document);
        return document;
    }
    
    /**
     * get the last report client
     * @param client collection name
     * @return
     */
    public Document getLastReport(String client){
    	return db.getCollection(client).find().sort(descending("_id")).first();
    }
    
    /**
     * get the last n reports of client
     * @param client collection name
     * @param cuantity to return
     * @return last n reports
     */
    public FindIterable<Document> getLastResports(String client, int cuantity){
    	if (cuantity < 100){
    		return db.getCollection(client).find().sort(descending("_id")).limit(cuantity);
    	}
    	return null;
    }
}
