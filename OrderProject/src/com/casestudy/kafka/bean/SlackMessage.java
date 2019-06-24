package com.casestudy.kafka.bean;

import java.io.Serializable;

public class SlackMessage implements Serializable {
	
	  private String username;
	    private String text;

	    public SlackMessage() {
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getText() {
	        return text;
	    }

	    public void setText(String text) {
	        this.text = text;
	    }

	    public SlackMessage(String userName, String text) {
	        this.username = userName;
	        this.text = text;
	    }

}
