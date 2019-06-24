package com.casestudy.notification.service;

import com.casestudy.notification.models.SlackMessage;
import com.casestudy.notification.slack.NotificationUtils;
import com.casestudy.notification.slack.SlackUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@EnableKafka
public class SlackConsumerService {

    @Autowired
    NotificationUtils notificationService;


    private final Logger logger = LoggerFactory.getLogger(SlackConsumerService.class);

    @KafkaListener(topics = "slack", groupId = "group_id")
    public void consume(SlackMessage slackMessage) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", slackMessage.getText()));
        String mailStatus = sendSlackMessage(slackMessage);
        logger.info("mailStatus===" + mailStatus);

    }

    @KafkaListener(topics = "slack", groupId = "group_id")
    public void consume(ConsumerRecord<String,String> consumerRecord) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s",consumerRecord.key()));
        String mailStatus = sendSlackMessageFromApp(consumerRecord);
        logger.info("mailStatus===" + mailStatus);

    }
    public String sendSlackMessage(SlackMessage slackMessage) {

        try {

            SlackUtils.sendMessage(slackMessage);
            System.out.println("test Message sent");
        } catch (Exception e) {
            e.printStackTrace();
            return "There was an error sending Message";

        }

        return "Message Sent";
    }

    public String sendSlackMessageFromApp(ConsumerRecord producerRecord) {

        try {

            SlackUtils.sendMessageFromApp(producerRecord);
            System.out.println("test Message sent");
        } catch (Exception e) {
            e.printStackTrace();
            return "There was an error sending Message";

        }

        return "Message Sent";
    }
}

