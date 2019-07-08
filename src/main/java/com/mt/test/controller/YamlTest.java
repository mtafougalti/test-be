package com.mt.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.mt.test.model.Server;
import com.mt.test.model.YamlConfig;

public class YamlTest {
	

	public static void main(String[] args) throws IOException {
		YamlConfig config = YamlProcessor.loadYaml1();
		Map<String, Server> map = new HashMap<>();
		map.put("hom", new Server("glxhomac11", "socgen.glxhomac11.fr", "fr", "paris", "glxhom11", config.getEnvironment().get("hom")));
		if(config.getInfrastructure() == null) {
			config.setInfrastructure(new HashMap<>());
		}
		config.getInfrastructure().put("ac", map);
		YamlProcessor.saveYaml1(config);

	}

}
