package com.green.org.demomapstruct.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class  GreetingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingService.class);

    public String greet() {
        String value = "aaa";
        LOGGER.trace("doStuff needed more information - {}", value);
        LOGGER.debug("doStuff needed to debug - {}", value);
        LOGGER.info("doStuff took input - {}", value);
        LOGGER.warn("doStuff needed to warn - {}", value);
        LOGGER.error("doStuff encountered an error with value - {}", value);
        return "Hello, World from greeting service";
    }
}