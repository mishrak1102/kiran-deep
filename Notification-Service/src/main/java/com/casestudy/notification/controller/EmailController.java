package com.casestudy.notification.controller;

import com.casestudy.notification.models.Notification;
import com.casestudy.notification.slack.NotificationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    NotificationUtils notificationService;

    /**+
     *
     * @param notification
     * @return the status of final call
     */
    @RequestMapping("/sendMail")
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

