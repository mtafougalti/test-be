package com.mt.test.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GalaxyConfig {
	private Map<String, Map<String, String>> environment;
    private Map<String, Map<String, Map<String, Object>>> infrastructure;
    private Map<String, Map<String, Map<String, Object>>> software;

}
