package com.rbs.sgl.consuldemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix="my")
@Data
public class MyConfig {
	
	private String firstName;
	private String secondName;
	private String thirdName;
	private String fourthName;
	private String fifthName;

}
