package com.shashank.demo.dto;

public class PaymentDto {
	private double amount;
	private double taxAmount;
	private double psc;
	private double pdc;
	private double totalAmount;
	private String transactionUID;
	private String productCode;
	private String signedFields;
	private String signature;
	private String sucessUrl;
	private String faliureUrl;
	
	public PaymentDto() {
		super();
	}
	
	public PaymentDto(double amount, double taxAmount, double psc, double pdc, double totalAmount,
			String transactionUID, String productCode, String signedFields, String signature, String sucessUrl,
			String faliureUrl) {
		super();
		this.amount = amount;
		this.taxAmount = taxAmount;
		this.psc = psc;
		this.pdc = pdc;
		this.totalAmount = totalAmount;
		this.transactionUID = transactionUID;
		this.productCode = productCode;
		this.signedFields = signedFields;
		this.signature = signature;
		this.sucessUrl = sucessUrl;
		this.faliureUrl = faliureUrl;
	}



	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getPsc() {
		return psc;
	}

	public void setPsc(double psc) {
		this.psc = psc;
	}

	public double getPdc() {
		return pdc;
	}

	public void setPdc(double pdc) {
		this.pdc = pdc;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTransactionUID() {
		return transactionUID;
	}

	public void setTransactionUID(String transactionUID) {
		this.transactionUID = transactionUID;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getSignedFields() {
		return signedFields;
	}

	public void setSignedFields(String signedFields) {
		this.signedFields = signedFields;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSucessUrl() {
		return sucessUrl;
	}

	public void setSucessUrl(String sucessUrl) {
		this.sucessUrl = sucessUrl;
	}

	public String getFaliureUrl() {
		return faliureUrl;
	}

	public void setFaliureUrl(String faliureUrl) {
		this.faliureUrl = faliureUrl;
	}
	
	
}
