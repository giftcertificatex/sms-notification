package com.giftok.smsnotification.model;

public class SmsMessage {

	private final String smsMessage;

	public SmsMessage(String smsMessage) {
		this.smsMessage = smsMessage;
	}

	public String smsMessage() {
		return smsMessage;
	}
}
