package com.example.restapi;

import com.example.restapi.models.User;
import com.example.restapi.repositories.CustomRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class CustomRepositoryImpl implements CustomRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void addUser(String user_id, String name, String email, String mobile_no){
        new User(user_id,name,email,mobile_no);
    }

    @Override
    public long updateUser(String user_id, String name, String email, String mobile_no) {
        Query query = new Query(Criteria.where("user_id").is(user_id));
        Update update = new Update();
        update.set("name",name);
        update.set("email",email);
        update.set("mobile_no",mobile_no);

        UpdateResult result = mongoTemplate.updateFirst(query,update, User.class);

        if(result != null){
            System.out.println("User updated successfully!");
            return result.getModifiedCount();
        }
        else
            return 0;
    }
}
