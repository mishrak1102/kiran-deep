package com.casestudy.kafka;
import org.slf4j.Logger;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.LoggerFactory;

import com.casestudy.kafka.bean.SlackMessage;
import com.casestudy.kafka.serialize.NotificationSerializer;

import java.util.Properties;

public class JavaKafkaProducer {
    private final static String TOPIC = "slack";
    private final static String BOOTSTRAP_SERVERS = "localhost:9092";
    
    static Logger logger=LoggerFactory.getLogger(JavaKafkaProducer.class);


public static void main(String[] args) throws Exception {
   
        runProducer();

}

    private static Producer<String, SlackMessage> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                                            BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "JavaKafkaProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        		StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                                    NotificationSerializer.class.getName());
        return new KafkaProducer(props);
        
        
        
    }
    
    static void runProducer() throws Exception {
        final Producer<String, SlackMessage> producer = createProducer();
        long time = System.currentTimeMillis();
        try {
           
                
            	SlackMessage slackMesssage=new SlackMessage("Order APP:", "Hello Your order is placed. We'll notify you shortly about shipment details");
            	
            	Producer<String,SlackMessage> kafkaProducer = createProducer();

                kafkaProducer.send(new ProducerRecord<>(TOPIC, "0", slackMesssage)).get();
                logger.info("Messsage Sent");
           
        } finally {
            producer.flush();
            producer.close();
        }
    }
}