package com.sarvatra.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.sarvatra.constants.Constants.LOCATION_UPDATE_TOPIC;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic() {

        return TopicBuilder
                .name(LOCATION_UPDATE_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }

}
