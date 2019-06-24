package com.casestudy.notification.service;

import com.casestudy.notification.models.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducerService {


    private static final Logger logger = LoggerFactory.getLogger(NotificationProducerService.class);
    private static final String TOPIC = "notifications";

    @Autowired
    private KafkaTemplate<String, Notification> kafkaTemplate;

    public void sendMessage(Notification notification) {
        logger.info(String.format("#### -> Producing message -> %s", notification.getSubject()));
        this.kafkaTemplate.send(TOPIC, notification);
        logger.info(String.format("#### -> Message Sent -> %s", notification));

    }
}

