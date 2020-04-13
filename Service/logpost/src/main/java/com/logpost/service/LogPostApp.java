package com.logpost.service;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Springboot entry point for Log Post service
 * 
 * @author  Deepesh Dhapola
 * @version 1.0
 * @since   2020-04-11
 * 
 */
@SpringBootApplication
@EnableEurekaClient
public class LogPostApp {


	/**
	 * Main method, entry point for springboot application
	 * @param args
	 */
    public static void main(String[] args) {
		SpringApplication.run(LogPostApp.class, args);
	}

}