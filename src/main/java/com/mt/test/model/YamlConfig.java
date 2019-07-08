package com.mt.test.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YamlConfig {
	private Map<String, Environment> environment;
	private Map<String, Map<String, Server>> infrastructure;

}
