package com.giftok.smsnotification.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PhoneNumberTest {
	
	@Test
	public void shouldThrowIllegualArgumentException() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("380976545"));
	    assertEquals("380976545 is incorrect. Phone Number should start from '+'", exception.getMessage());
	}

}
