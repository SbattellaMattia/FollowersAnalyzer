package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import it.Twitter.FollowersAnalyzer.Model.User;

@JsonComponent
public class JsonToString {
	 public static class Serializer extends JsonSerializer<User> {

	        @Override
	        public void serialize(User user, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
	        	jgen.writePOJOField("id", user.getId());
	            jgen.writeStringField("name", user.getName());
	            jgen.writeStringField("username", user.getUsername());
	        }

	    }

}
