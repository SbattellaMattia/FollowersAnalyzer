package it.Twitter.FollowersAnalyzer.JsonComponent;

import org.springframework.boot.json.JsonParser;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.Twitter.FollowersAnalyzer.Model.User;

public interface Json {
	public void serialize(User user, JsonGenerator jgen, SerializerProvider serializers);
	public User deserialize(JsonParser jsonParser, DeserializationContext txt);
	

}
