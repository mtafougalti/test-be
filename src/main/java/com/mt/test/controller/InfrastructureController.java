package com.mt.test.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esotericsoftware.yamlbeans.YamlException;
import com.mt.test.model.Server;
import com.mt.test.services.YamlService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InfrastructureController {
	@RequestMapping(value = "/infraList", method = RequestMethod.GET, produces = "application/json")
	public Map<String, List<Server>> loadYaml() throws FileNotFoundException, YamlException {
		return YamlService.getServerMap();
	}
}
