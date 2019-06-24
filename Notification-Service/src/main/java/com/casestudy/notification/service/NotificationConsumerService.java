package com.casestudy.notification.service;

import com.casestudy.notification.models.Notification;
import com.casestudy.notification.slack.NotificationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@org.springframework.stereotype.Service
@EnableKafka
public class NotificationConsumerService {

    @Autowired
    NotificationUtils notificationService;


    private final Logger logger = LoggerFactory.getLogger(NotificationConsumerService.class);

    @KafkaListener(topics = "notifications", groupId = "group_id")
    public void consume(Notification notification) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", notification.getSubject()));
        String mailStatus = sendEmailToUser(notification);
        logger.info("mailStatus===" + mailStatus);

    }

    public String sendEmailToUser(Notification notification) {

        try {
            notificationService.sendNotification(notification);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return "There was an error sending email";

        }
        return "Email Sent";
    }
}

