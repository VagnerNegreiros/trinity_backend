package com.trinity.vagnernegreiros.backend.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
	public static String generateMD5(String message) {
		try {
			String s= message;
		    MessageDigest m = MessageDigest.getInstance("MD5");
		    m.update(s.getBytes(),0,s.length());	    
		    return new BigInteger(1,m.digest()).toString(16);
		} catch(Exception e) {
			System.out.println("Ocorreu um erro");
		}
		return message;
	}
}
