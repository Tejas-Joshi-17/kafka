package com.sarvatra.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.sarvatra.constants.Constants.LOCATION_UPDATE_TOPIC;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean updateLocation(String location) {
        this.kafkaTemplate.send(LOCATION_UPDATE_TOPIC, location);
        return true;
    }


}
