package com.example.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.controller,com.example.service,com.example.serviceImpl" })
@MapperScan(value="com.example.mapper")
@EnableScheduling
@ServletComponentScan(basePackages = "com.example.init")
public class DallApplication {
//	private static Logger logger = Logger.getLogger(DallApplication.class);

	public static void main(String[] args) {
		//logger.info("Strat...");
		SpringApplication.run(DallApplication.class, args);
	}

}

