package com.sarvatra.controller;


import com.sarvatra.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/delivery")
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update-location")
    public ResponseEntity<Map<String, String>> updateLocation() {

        String xCoordinate = String.valueOf(Math.floor(Math.random() * 100));
        String yCoordinate = String.valueOf(Math.ceil(Math.random() * 100));

        String location = "(" + xCoordinate + ", " + yCoordinate + ")";

        this.kafkaService.updateLocation(location);

        logger.info("Location Updated :- ({}, {})", xCoordinate, yCoordinate);

        return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);

    }

}