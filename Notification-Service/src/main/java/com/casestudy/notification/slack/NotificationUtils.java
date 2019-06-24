package com.casestudy.notification.slack;

import com.casestudy.notification.models.Notification;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationUtils {

    private JavaMailSender javaMailSender;


    public NotificationUtils(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(Notification notification) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(notification.getFromAddress());
        simpleMailMessage.setTo(notification.getToAddress());
        simpleMailMessage.setSubject(notification.getSubject());
        simpleMailMessage.setText(notification.getMessageData());

        javaMailSender.send(simpleMailMessage);
    }

}
