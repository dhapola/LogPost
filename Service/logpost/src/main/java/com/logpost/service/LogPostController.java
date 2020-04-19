package com.logpost.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class provides REST APIs for accepting log messages from service consumers
 * 
 * @author  Deepesh Dhapola
 * @version 1.0
 * @since   2020-04-11
 * 
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/")

public class LogPostController{

	private final String MESSAGE = "Log Post Service Running";

	Logger _logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Provides Service Heartbeat
	 * @return
	 */
    @GetMapping(value = "/status", produces="text/plain")
	public String home() {

		_logger.info(MESSAGE);
	 	return MESSAGE;
	}


	/**
	 * info method is used for logging information log messages
	 * @return
	 */
	
	@PostMapping(value = "/info", produces="text/plain")
	public String logInfo(@RequestBody String message) {

		_logger.info(message);
		return "";

	}

	/**
	 * error method is used for logging error or exception log messages
	 * @return
	 */
	
	@PostMapping(value = "/err", produces="text/plain")
	public String logError(@RequestBody String message) {

		_logger.error(message);
		return "";
	}

	/**
	 * warn method is used for warning log messages
	 * @return
	 */
	@PostMapping(value="/warn", produces="text/plain")
	public String logWarn(@RequestBody String message) {

		_logger.warn(message);
		return "";
	}
}