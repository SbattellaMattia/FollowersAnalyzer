package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.json.JsonParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import it.Twitter.FollowersAnalyzer.Model.User;
//TO DO
/*
@JsonComponent
public class JsonDeserialize extends JsonDeserializer<User>{


	        
	        public User deserialize(JsonParser jsonParser, DeserializationContext txt) throws IOException, JsonProcessingException {
	            ObjectCodec codec = jsonParser.getCodec();
	            JsonNode tree = codec.readTree(jsonParser);
	            
	            Long Id = tree.get("id").longValue();
	            String name = tree.get("name").textValue();
	            String username = tree.get("username").textValue();
	            return new User(Id,name,username);
	        }

}*/
