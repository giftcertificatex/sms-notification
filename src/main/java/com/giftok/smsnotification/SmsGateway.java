package com.giftok.smsnotification;

import com.giftok.smsnotification.model.PhoneNumber;
import com.giftok.smsnotification.model.SmsMessage;

public interface SmsGateway {

	boolean send(PhoneNumber to, SmsMessage smsMessage);
}
