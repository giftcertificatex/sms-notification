package com.giftok.smsnotification.twillio;

import com.giftok.smsnotification.SmsGateway;
import com.giftok.smsnotification.model.PhoneNumber;
import com.giftok.smsnotification.model.SmsMessage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class TwillioSmsGateWay implements SmsGateway {

	private static String getAccountSid() {
		return "AC3dc5ca04311386b40199cc4d592ad9ea";
	}

	private static String getAuthToken() {
		return "91031108c11b71d238d8b0c856bc4721";
	}
	
	private static com.twilio.type.PhoneNumber fromNumber() {
		return new com.twilio.type.PhoneNumber("+14803748666");
	}

	static {
		Twilio.init(getAccountSid(), getAuthToken());
	}

	@Override
	public boolean send(PhoneNumber to, SmsMessage smsMessage) {
		 var message = Message.creator(toTwillioPhoneNumber(to),
				 fromNumber(), 
				 smsMessage.smsMessage()).create();
		 
		 message.getStatus();
		 
		 return true;
	}

	private com.twilio.type.PhoneNumber toTwillioPhoneNumber(PhoneNumber to) {
		var result  = new com.twilio.type.PhoneNumber(to.phoneNumber());
		return result;
	}
}
