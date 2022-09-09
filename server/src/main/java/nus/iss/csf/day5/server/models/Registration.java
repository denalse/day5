package nus.iss.csf.day5.server.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;

public class Registration {

    private String id; //optional
    private String name;
    private String email;

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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public static Registration create(String json) {
        
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject data = reader.readObject();
        
        final Registration reg = new Registration();
        reg.setName(data.getString("name"));
        reg.setEmail(data.getString("email"));
        
        // check id json object has id in the payload, it is optional
        if (data.containsKey("id"))
            reg.setId(data.getString("id"));

        //JsonObjectBuilder builder = Json.createObjectBuilder()
        return reg;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("id", id)
            .add("name", name)
            .add("email", email)
            .build();
    }


    
}
