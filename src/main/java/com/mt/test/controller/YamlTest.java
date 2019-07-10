package com.mt.test.controller;

import java.io.FileNotFoundException;

import com.esotericsoftware.yamlbeans.YamlException;
import com.mt.test.model.GalaxyConfig;
import com.mt.test.services.YamlProcessor;

public class YamlTest {
	

	public static void main(String[] args) throws FileNotFoundException, YamlException {
		GalaxyConfig config = YamlProcessor.loadYaml();
	}

}
