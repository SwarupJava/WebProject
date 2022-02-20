package com.ashokit.usermgmt.util;

import java.security.SecureRandom;

public class AppUtil {

	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	private static final String NUMBER = "0123456789";
	private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
	static SecureRandom random = new SecureRandom();
	
	public static String generateRandomString(int length) {
		if(length<1) {
			throw new IllegalArgumentException();
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<length; i++) {
			int randomCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
			char randomChar = DATA_FOR_RANDOM_STRING.charAt(randomCharAt);
			sb.append(randomChar);
		}
		return sb.toString();
	}
}
