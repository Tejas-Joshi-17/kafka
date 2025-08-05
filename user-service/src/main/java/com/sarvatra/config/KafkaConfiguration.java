package com.sarvatra.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import static com.sarvatra.constants.Constants.CONSUMER_GROUP_ID;
import static com.sarvatra.constants.Constants.LOCATION_UPDATE_TOPIC;

@Configuration
public class KafkaConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConfiguration.class);

    @KafkaListener(topics = LOCATION_UPDATE_TOPIC, groupId = CONSUMER_GROUP_ID)
    public void updatedLocation(String updatedLocation) {
        logger.info("Updated Location :- {}", updatedLocation);
    }

}