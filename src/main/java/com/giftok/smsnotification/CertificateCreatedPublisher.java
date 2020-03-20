package com.giftok.smsnotification;

import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

import com.giftok.certeficate.message.CertificateMessageOuterClass.CertificateMessage;

public class CertificateCreatedPublisher extends SubmissionPublisher<CertificateMessage> {

	public CertificateCreatedPublisher(Executor executor) {
		super(executor, Flow.defaultBufferSize());
	}
}
