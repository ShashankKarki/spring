package com.shashank.demo.service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

	@SuppressWarnings("deprecation")
	@Override
	public String generateEsewaSignature(String secrect, String messsage) {
		String hash="";
		try {
		
			 Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			 SecretKeySpec secret_key = new SecretKeySpec(secrect.getBytes(),"HmacSHA256");
			 sha256_HMAC.init(secret_key);
			
			hash = Base64.encodeBase64String(sha256_HMAC.doFinal(messsage.getBytes()));
			 System.out.println(hash);
			 }
			 catch (Exception e){
			 System.out.println("Error");
			}
		return hash;
	}

}
