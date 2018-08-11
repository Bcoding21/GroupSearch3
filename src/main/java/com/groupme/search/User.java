package com.groupme.search;

import org.json.JSONObject;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Represents a user of group me.
 */

@Entity
public class User {

    @Id
    private String id;
    private String nickName;

    public User(){

    }

    public User(JSONObject jsonObject){
        id = jsonObject.getString("user_id");
        nickName = jsonObject.getString("nickname");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
