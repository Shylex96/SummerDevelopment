package models;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;

public class UserDatabaseManager {

	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;

	public boolean insert;
	public boolean exist;

	public UserDatabaseManager() {

		try {

			// MongoDB Config
			MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");

			mongoClient = new MongoClient(uri);
			database = mongoClient.getDatabase("quizmasters");
			collection = database.getCollection("users");

			System.out.println("Connection to MongoDB established and database is up.");

		} catch (Exception e) {

			System.err.println("Error connecting to MongoDB: " + e.getMessage());
		}
	}

	public void insertData(String nickname, String password) {

		// Validate 
		if (isValidData(nickname, password)) {

			if (isNicknameInUse(nickname)) {
				
				// Nickname already in use
				exist = true;
				
			} else {
				
				// Everything OK - Insert a new document with user data
				Document document = new Document("nickname", nickname)
						.append("password", password);
				collection.insertOne(document);

				insert = true;

			}
		} else {
			insert = false;
		}
	}

	private boolean isNicknameInUse(String nickname) {
		
		Document existingUser = collection.find(Filters.eq("nickname", nickname)).first();
        return existingUser != null;
	}

	private boolean isValidData(String nickname, String password) {

		// Filters
		return !nickname.isEmpty() && !password.isEmpty();
	}

	public boolean obtainUserData(String nickname, String password) {

		Document filter = new Document("nickname", nickname).append("password", password);
		Document result = collection.find(filter).first();

		return result != null;
	}

	public void closeConnection() {
		if (mongoClient != null) {
			mongoClient.close();
			System.out.println("Connection to MongoDB closed.");
		}
	}


}
