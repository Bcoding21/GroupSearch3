package com.groupme.search;

import org.json.JSONArray;
import org.json.JSONObject;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */
@Entity("groupchats")
public class GroupChat {

    @Id
    private String id;
    private String name;
    @Reference
    private List<User> members;
    private String lastMessageStoredId;

    public GroupChat(){

    }

    public GroupChat(JSONObject jsonObject){
        id = jsonObject.getString("id");
        name = jsonObject.getString("name");
        members = getMembers(jsonObject);
    }

    private List<User> getMembers(JSONObject jsonObject){


        JSONArray jsonArray = jsonObject.getJSONArray("members");

        List<User> members = IntStream.range(0, jsonArray.length())
                .mapToObj(jsonArray::getJSONObject)
                .map(User::new)
                .collect(Collectors.toList());


        return members;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public String getLastMessageStoredId() {
        return lastMessageStoredId;
    }

    public void setLastMessageStoredId(String lastMessageStoredId) {
        this.lastMessageStoredId = lastMessageStoredId;
    }



}
