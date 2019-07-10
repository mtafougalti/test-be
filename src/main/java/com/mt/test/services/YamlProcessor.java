package com.mt.test.services;

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
import com.mt.test.model.GalaxyConfig;

public class YamlProcessor {

	private static final String YAML_FILE = "src//main//resources//test.yaml";

	public static GalaxyConfig loadYaml() throws FileNotFoundException, YamlException {
		YamlReader reader = new YamlReader(new FileReader(YAML_FILE));
		GalaxyConfig config = reader.read(GalaxyConfig.class);
		return config;
	}

	public static void saveYaml(GalaxyConfig config) throws IOException {
		YamlWriter writer = new YamlWriter(new FileWriter(YAML_FILE));
		writer.write(config);
		writer.close();
	}

	public static GalaxyConfig loadYaml1() throws FileNotFoundException {
		Constructor constructor = new Constructor(GalaxyConfig.class);
		Yaml yaml = new Yaml(constructor);
		InputStream input = new FileInputStream(new File(YAML_FILE));
		GalaxyConfig data = yaml.load(input);
		return data;

	}

	public static void saveYaml1(GalaxyConfig data) throws IOException {
		Constructor constructor = new Constructor(GalaxyConfig.class);
		Yaml yaml = new Yaml(constructor);
		yaml.dump(data, new FileWriter(YAML_FILE));
		System.out.println(yaml.dumpAs(data, Tag.MAP, null));
	}

}
