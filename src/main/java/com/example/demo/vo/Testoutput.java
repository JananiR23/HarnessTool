package com.example.demo.vo;

public class Testoutput {
	
	private String id;
	
	private String applicationIdentity;
	
	public String getApplicationIdentity() {
		return applicationIdentity;
	}

	public void setApplicationIdentity(String applicationIdentity) {
		this.applicationIdentity = applicationIdentity;
	}

	private String bankDivision;
	
	private String productFamily;
	
	private String productName;

	private Integer barrowAmount;
	
	private Integer termFactor;
	
	private Integer riskFactor;

	/*
	 * public void setAnnualPercentageRate(Float annualPercentageRate) {
	 * this.annualPercentageRate = annualPercentageRate; }
	 */

	/*
	 * public String getLicationIdentity() { return licationIdentity; }
	 * 
	 * public void setLicationIdentity(String licationIdentity) {
	 * this.licationIdentity = licationIdentity; }
	 */

	public String getBankDivision() {
		return bankDivision;
	}

	public void setBankDivision(String bankDivision) {
		this.bankDivision = bankDivision;
	}

	public String getProductFamily() {
		return productFamily;
	}

	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getBarrowAmount() {
		return barrowAmount;
	}

	public void setBarrowAmount(Integer barrowAmount) {
		this.barrowAmount = barrowAmount;
	}

	public Integer getRiskFactor() {
		return riskFactor;
	}

	public void setRiskFactor(Integer riskFactor) {
		this.riskFactor = riskFactor;
	}

	public Integer getTermFactor() {
		return termFactor;
	}

	public void setTermFactor(Integer termFactor) {
		this.termFactor = termFactor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
