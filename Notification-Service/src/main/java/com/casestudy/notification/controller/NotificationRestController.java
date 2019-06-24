package com.casestudy.notification.controller;

import com.casestudy.notification.models.Notification;
import com.casestudy.notification.service.NotificationProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class NotificationRestController {


    private NotificationProducerService producer;

    NotificationRestController(NotificationProducerService producer) {
        this.producer = producer;
    }

    /**+
     *
     * @param message
     * @return Status
     */
    @GetMapping("/publish/{message}")
    public String sendMessageToKafkaTopic(@PathVariable("message") String message) {
        this.producer.sendMessage(new Notification("kirandeepjune@gmail.com", "kirankalra0804@gmail.com", "Your Ticket number XXXX is in Progress", "Your Ticket Number XXX is assigned to abc@yz.com. We'll notify you once service agent updates your ticket. \n Thank you for your patience"));
        return "PUBLISHED";
    }
}