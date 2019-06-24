package com.casestudy.notification;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
        (exclude = BatchAutoConfiguration.class)
public class NotificationServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(NotificationServiceApplication.class, args);
        logger.info("Application Started");

    }


}
