package com.casestudy.notification.service;

import com.casestudy.notification.models.SlackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SlackProducerService {


    private static final Logger logger = LoggerFactory.getLogger(SlackProducerService.class);
    private static final String TOPIC = "slack";

    @Autowired
    private KafkaTemplate<String, SlackMessage> kafkaTemplate;

    public void sendMessage(SlackMessage slackMessage) {
        logger.info(String.format("#### -> Producing message -> %s", slackMessage.getText()));
        this.kafkaTemplate.send(TOPIC, slackMessage);
        logger.info(String.format("#### -> Message Sent -> %s", slackMessage.getText()));

    }
}

