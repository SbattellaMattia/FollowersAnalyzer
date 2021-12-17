package it.Twitter.FollowersAnalyzer.JsonComponent;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"id","name","username"})
public class JsonUser {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("username")
	private String username;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 *
	 * @return
	 * The id
	 */
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 * The id
	 */
	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 *
	 * @return
	 * The firstName
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param firstName
	 * The firstName
	 */
	@JsonProperty("name")
	public void setFirstName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return
	 * The lastName
	 */
	@JsonProperty("username")
	public String getLastName() {
		return username;
	}

	/**
	 *
	 * @param lastName
	 * The lastName
	 */
	@JsonProperty("lastName")
	public void username(String username) {
		this.username = username;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
