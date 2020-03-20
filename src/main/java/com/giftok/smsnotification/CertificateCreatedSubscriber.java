package com.giftok.smsnotification;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.giftok.certeficate.message.CertificateMessageOuterClass.CertificateMessage;


public class CertificateCreatedSubscriber implements Subscriber<CertificateMessage> {

	private Subscription subscription;
	
	private long processed;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(CertificateMessage item) {
		processed++;
		subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		
	}
	
	public long getProcessed() {
		return processed;
	}

}
