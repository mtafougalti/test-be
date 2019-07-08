package com.mt.test.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esotericsoftware.yamlbeans.YamlException;
import com.mt.test.model.Environment;
import com.mt.test.model.YamlConfig;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EnvironmentController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
	public Map<String, String> hello() {
		Map<String, String> model = new HashMap<>();
		model.put("greeting", "Hello World!");
		return model;
	}
	
	@RequestMapping(value = "/yaml", method = RequestMethod.GET, produces = "application/json")
	public YamlConfig loadYaml() throws FileNotFoundException, YamlException {
	 	return YamlProcessor.loadYaml();
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public Environment get(@PathVariable String id) throws IOException{
		System.out.println("id : " + id);
		YamlConfig config = YamlProcessor.loadYaml();
		return config.getEnvironment().get(id);
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public void save(@RequestBody Environment env) throws IOException{
		System.out.println("env : " + env);
		YamlConfig config = YamlProcessor.loadYaml();
		config.getEnvironment().put(env.getId(), env);
		YamlProcessor.saveYaml(config);
    } 
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    public void update(@RequestBody Environment env) throws IOException{
		System.out.println("env : " + env);
		YamlConfig config = YamlProcessor.loadYaml();
		config.getEnvironment().put(env.getId(), env);
		YamlProcessor.saveYaml(config);
    }
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public YamlConfig delete(@PathVariable String id) throws IOException{
		System.out.println("id : " + id);
		YamlConfig config = YamlProcessor.loadYaml();
		config.getEnvironment().remove(id);
		YamlProcessor.saveYaml(config);
		return config;
    }
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET, produces = "application/json")
	public String hi() {
		return "Hi All!";
	}

}
