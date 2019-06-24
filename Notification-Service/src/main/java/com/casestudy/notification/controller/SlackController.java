package com.casestudy.notification.controller;

import com.casestudy.notification.service.SlackProducerService;
import com.casestudy.notification.models.SlackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slack")
public class SlackController {

    @Autowired
    private SlackProducerService producer;

    SlackController(SlackProducerService producer) {
        this.producer = producer;
    }

    /**+
     *
     * @param message
     * @return the status of Operation
     */
    @GetMapping("/bot/{message}")
    public String sendMessageToKafkaTopic(@PathVariable("message") String message) {
        this.producer.sendMessage(new SlackMessage("Incident Management:", "Your Ticket is in In Progress State. You will be notified when there is further update"));
        return "PUBLISHED";
    }

}
