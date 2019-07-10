package com.mt.test.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {

	private String id;
	private String shortname;
	private String longname;
	private String zone;
	private String location;
	private String user;
	private Environment env;

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("shortname", this.shortname);
		map.put("longname", this.longname);
		map.put("zone", this.zone);
		map.put("location", this.location);
		map.put("user", this.user);
		map.put("env", this.env.toMap());
		return map;
	}

	public void fromMap(String key, Map<String, Object> map) {
		 this.id = key;
		this.shortname = (String) map.get("shortname");
		this.longname = (String) map.get("longname");
		this.zone = (String) map.get("zone");
		this.location = (String) map.get("location");
		this.user = (String) map.get("user");
		Environment env = new Environment();
		env.fromMap(key, (Map<String, String>) map.get("env"));
		this.env = env;
	}

	public void fitMap(Map<String, Object> map) {
		map.put("shortname", this.shortname);
		map.put("longname", this.longname);
		map.put("zone", this.zone);
		map.put("location", this.location);
		map.put("user", this.user);
		map.put("env", this.env.toMap());
	}

}
