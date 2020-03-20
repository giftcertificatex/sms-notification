package com.giftok.smsnotification.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.giftok.certeficate.message.CertificateMessageOuterClass.CertificateMessage;
import com.giftok.smsnotification.CertificateCreatedPublisher;
import com.giftok.smsnotification.CertificateCreatedSubscriber;

public class AppTest {

	@Test
	public void shouldRunFlow() throws Exception {
		
		var message = CertificateMessage.newBuilder().setId("testId").build();
		var executor = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
		var certificateCreatedPublisher = new CertificateCreatedPublisher(executor);
		var certificateCreatedSubsciber = new CertificateCreatedSubscriber();
		certificateCreatedPublisher.subscribe(certificateCreatedSubsciber);
		certificateCreatedPublisher.submit(message);
		while(executor.getCompletedTaskCount()!=1) {}
		assertEquals(1, certificateCreatedSubsciber.getProcessed());
		certificateCreatedPublisher.close();
		
	}
	
}
