package com.giftok.smsnotification.model;

public class PhoneNumber {

	private final String phoneNumber;

	public PhoneNumber(String phoneNumber) {

		if (phoneNumber.charAt(0) != '+')
			throw new IllegalArgumentException(phoneNumber + " is incorrect. Phone Number should start from '+'");

		this.phoneNumber = phoneNumber;
	}

	public String phoneNumber() {
		return phoneNumber;
	}
}
