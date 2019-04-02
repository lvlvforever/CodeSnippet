/**
 * Description:
 * User: daipeng
 * Date: 2018-11-26 14:13
 * Project:CodeSnippet
 */
package mongodb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.Server;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MongodbService {
    public static void main(String[] args) {


        MongoClientURI uri = new MongoClientURI("mongodb://BookAtomConsole:BookAtomConsole@localhost:27017/BookAtomConsole");
        MongoClient mongoClient = new MongoClient(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("BookAtomConsole");


        MongoClientOptions options = mongoClient.getMongoClientOptions();
        MongoCollection<Document> collection = mongoDatabase.getCollection("bigUserCollection");

        JSONObject user = new JSONObject();
        for (int i = 0; i < 10000000; i++) {
            System.err.println(i);
            user.put("name", "zhangsan"+i);
            user.put("age", i);
            user.put("status", new Random().nextInt(10));
            Document document = Document.parse(JSON.toJSONString(user));
            collection.insertOne(document);
        }



        System.err.println("success");

    }
}
