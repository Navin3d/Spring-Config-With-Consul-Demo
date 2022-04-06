package com.rbs.sgl.consuldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbs.sgl.consuldemo.config.MyConfig;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(value = MyConfig.class)
public class ConsulDemoApplication {

	@Autowired
	private MyConfig config;

	@GetMapping("/getConfigData")
	public MyConfig getConfiguration() {
		return config;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsulDemoApplication.class, args);
	}

}
