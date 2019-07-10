package com.mt.test.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.esotericsoftware.yamlbeans.YamlException;
import com.mt.test.model.Environment;
import com.mt.test.model.GalaxyConfig;
import com.mt.test.model.Server;

public class YamlService {

	public static GalaxyConfig getGalaxyConfig() {
		try {
			return YamlProcessor.loadYaml();
		} catch (FileNotFoundException e) {
			return null;
		} catch (YamlException e) {
			return null;
		}
	}
//----- Infra-----------------
	public static Map<String, List<Server>> getServerMap() {
		GalaxyConfig galaxyConfig = getGalaxyConfig();
		Map<String, List<Server>> result = new HashMap<>();
		for (Entry<String, Map<String, Map<String, Object>>> entry : galaxyConfig.getInfrastructure().entrySet()) {
			List<Server> list = new ArrayList<>();
			for (Entry<String, Map<String, Object>> serverEntry : entry.getValue().entrySet()) {
				Server server = new Server();
				server.fromMap(serverEntry.getKey(), serverEntry.getValue());
				list.add(server);
			}
			result.put(entry.getKey(), list);
		}
		return result;
	}

//----- Environment-----------
	public static List<Environment> getEnvironmentList() {
		GalaxyConfig galaxyConfig = getGalaxyConfig();
		List<Environment> result = new ArrayList<>();
		for (Entry<String, Map<String, String>> envEntry : galaxyConfig.getEnvironment().entrySet()) {
			Environment env = new Environment();
			env.fromMap(envEntry.getKey(), envEntry.getValue());
			result.add(env);
		}
		return result;
	}

	public static void addEnvironment(Environment env) {
		GalaxyConfig galaxyConfig = getGalaxyConfig();
		galaxyConfig.getEnvironment().put(env.getId(), env.toMap());
		try {
			YamlProcessor.saveYaml(galaxyConfig);
		} catch (IOException e) {
			// TODO
		}
	}

	public static void updateEnvironment(Environment env) {
		GalaxyConfig galaxyConfig = getGalaxyConfig();
		env.fitMap(galaxyConfig.getEnvironment().get(env.getId()));
		try {
			YamlProcessor.saveYaml(galaxyConfig);
		} catch (IOException e) {
			// TODO
		}
	}

	public static GalaxyConfig deleteEnvironment(String envId) {
		GalaxyConfig galaxyConfig = getGalaxyConfig();
		galaxyConfig.getEnvironment().remove(envId);
		try {
			YamlProcessor.saveYaml(galaxyConfig);
		} catch (IOException e) {
			// TODO
		}
		return galaxyConfig;
	}

	public static Environment getEnvironmentById(String envId) {
		Environment env = new Environment();
		GalaxyConfig galaxyConfig = getGalaxyConfig();
		env.fromMap(envId, galaxyConfig.getEnvironment().get(envId));
		return env;
	}
}
