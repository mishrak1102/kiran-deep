package com.casestudy.notification.models;

public class Notification {

    public Notification() {
    }

    private String toAddress;

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String fromAddress;
    private String subject;

    public String getMessageData() {
        return messageData;
    }

    public void setMessagedDta(String messageData) {
        this.messageData = messageData;
    }

    private String messageData;

    public Notification(String toAddress, String fromAddress, String subject, String messageData) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.subject = subject;
        this.messageData = messageData;
    }
}