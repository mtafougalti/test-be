package com.mt.test.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
	@Setter(AccessLevel.NONE)
	private String id;
	private String name;
	private String description;
	private String database;

}
