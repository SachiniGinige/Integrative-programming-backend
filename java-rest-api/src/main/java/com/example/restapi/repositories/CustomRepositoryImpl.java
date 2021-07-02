package com.example.restapi.repositories;

import com.example.restapi.models.User;
import com.example.restapi.repositories.CustomRepository;
import com.mongodb.client.result.DeleteResult;
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
    public long updateUser(User user) {
        Query query = new Query(Criteria.where("user_id").is(user.getUser_id()));
        Update update = new Update();
        update.set("name",user.getName());
        update.set("email",user.getEmail());
        update.set("mobile_no",user.getMobile_no());

        UpdateResult result = mongoTemplate.updateFirst(query,update, User.class);

        if(result != null){
            System.out.println("User updated successfully under User ID: "+user.getUser_id());
            return result.getModifiedCount();
        }
        else
            return 0;
    }
}
