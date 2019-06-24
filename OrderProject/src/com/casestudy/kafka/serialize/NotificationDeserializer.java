package com.casestudy.kafka.serialize;

import com.casestudy.notification.models.Notification;
import com.casestudy.notification.slack.SlackMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class NotificationDeserializer implements Deserializer<Object> {

    private final Logger logger = LoggerFactory.getLogger(NotificationDeserializer.class);

    @Override
    public void close() {
    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {
    }

    @Override
    public Object deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        Notification notification = null;
        SlackMessage slackMessage = null;
        try {

            notification = mapper.readValue(arg1, Notification.class);

        } catch (Exception e) {
            logger.error("Object is not Notification Type.. Check for Slack Message");
            logger.error(e.getMessage());

            try {

                slackMessage = mapper.readValue(arg1, SlackMessage.class);

            } catch (Exception e1) {
                logger.error("Object is not Slack Message as well");

                logger.error(e.getMessage());
            }
            return slackMessage;
        }
        return notification;
    }
}