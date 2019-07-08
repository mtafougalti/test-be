package com.mt.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Tag;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.mt.test.model.Environment;
import com.mt.test.model.Server;
import com.mt.test.model.YamlConfig;

public class YamlProcessor {

	private static final String YAML_FILE = "src//main//resources//test.yaml";

	public static YamlConfig loadYaml() throws FileNotFoundException, YamlException {
		YamlReader reader = new YamlReader(new FileReader(YAML_FILE));
		reader.getConfig().setPropertyElementType(YamlConfig.class, "environment", Environment.class);
		reader.getConfig().setPropertyElementType(YamlConfig.class, "infrastructure", HashMap.class);
		reader.getConfig().setClassTag("Server", Server.class);
		YamlConfig config = reader.read(YamlConfig.class);
		return config;
	}

	public static void saveYaml(YamlConfig config) throws IOException {
		YamlWriter writer = new YamlWriter(new FileWriter(YAML_FILE));
		writer.getConfig().setPropertyElementType(YamlConfig.class, "environment", Environment.class);
		writer.getConfig().setPropertyElementType(YamlConfig.class, "infrastructure", HashMap.class);
		writer.getConfig().setClassTag("Server", Server.class);
		writer.write(config);
		writer.close();
	}

	public static YamlConfig loadYaml1() throws FileNotFoundException {
		Constructor constructor = new Constructor(YamlConfig.class);
		Yaml yaml = new Yaml(constructor);
		InputStream input = new FileInputStream(new File(YAML_FILE));
		YamlConfig data = yaml.load(input);
		return data;

	}

	public static void saveYaml1(YamlConfig data) throws IOException {
		Constructor constructor = new Constructor(YamlConfig.class);
		Yaml yaml = new Yaml(constructor);
		yaml.dump(data, new FileWriter(YAML_FILE));
		System.out.println(yaml.dumpAs(data, Tag.MAP, null));
	}

}
