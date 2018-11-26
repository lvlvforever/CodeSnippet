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

public class MongodbService {
    public static void main(String[] args) {


        MongoClientURI uri = new MongoClientURI("mongodb://BookAtomConsole:BookAtomConsole@localhost:27017/BookAtomConsole");
        MongoClient mongoClient = new MongoClient(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("BookAtomConsole");


        MongoClientOptions options = mongoClient.getMongoClientOptions();

        JSONObject user = new JSONObject();
        user.put("name", "zhangsan");
        user.put("weight", 180);
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        Document document = Document.parse(JSON.toJSONString(user));
        collection.insertOne(document);

        System.err.println("success");

    }
}
