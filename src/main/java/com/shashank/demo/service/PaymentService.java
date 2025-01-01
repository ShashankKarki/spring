package com.shashank.demo.service;

public interface PaymentService {
	public String generateEsewaSignature(String secrect, String messsage);
}
