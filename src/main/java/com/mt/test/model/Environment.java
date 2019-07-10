package com.mt.test.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
	private String id;
    private String name;
    private String description;
    private String database;

    public Map<String, String> toMap(){
          Map<String, String> map = new HashMap<>();
          map.put("name", this.name);
          map.put("description", this.description);
          map.put("database", this.database);
          return map;
    }
   
    public void fromMap(String key, Map<String, String> map){
          this.id = key;
          this.name = map.get("name");
          this.description = map.get("description");
          this.database = map.get("database");
    }
   
    public void fitMap(Map<String, String> map){
          map.put("name", this.name);
          map.put("description", this.description);
          map.put("database", this.database);
    }
}
