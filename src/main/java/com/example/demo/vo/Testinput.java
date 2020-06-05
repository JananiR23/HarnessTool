package com.example.demo.vo;

import java.util.List;

public class Testinput {
	
	private List<Integer> barrowAmount;
	
	public List<Integer> getBarrowAmount() {
		return barrowAmount;
	}

	public void setBarrowAmount(List<Integer> barrowAmount) {
		this.barrowAmount = barrowAmount;
	}

	public List<Integer> getRiskFactor() {
		return riskFactor;
	}

	public void setRiskFactor(List<Integer> riskFactor) {
		this.riskFactor = riskFactor;
	}

	public List<Integer> getTermFactor() {
		return termFactor;
	}

	public void setTermFactor(List<Integer> termFactor) {
		this.termFactor = termFactor;
	}

	private List<Integer> riskFactor;
	
	private List<Integer> termFactor;
	
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

	

}
