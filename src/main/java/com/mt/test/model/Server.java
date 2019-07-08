package com.mt.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {
	  
	 private String shortname;
	 private String longname;
	 private String zone;
	 private String location;
	 private String user;
	 private Environment env;

}
