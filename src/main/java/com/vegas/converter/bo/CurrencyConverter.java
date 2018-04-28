package com.vegas.converter.bo;

public class CurrencyConverter {
	private String sourceCountryCode;
	private String targetCountryCode;
	private double inputAmount;
	private double outputAmount;

	public String getSourceCountryCode() {
		return sourceCountryCode;
	}

	public void setSourceCountryCode(String sourceCountryCode) {
		this.sourceCountryCode = sourceCountryCode;
	}

	public String getTargetCountryCode() {
		return targetCountryCode;
	}

	public void setTargetCountryCode(String targetCountryCode) {
		this.targetCountryCode = targetCountryCode;
	}

	public double getInputAmount() {
		return inputAmount;
	}

	public void setInputAmount(double inputAmount) {
		this.inputAmount = inputAmount;
	}

	public double getOutputAmount() {
		return outputAmount;
	}

	public void setOutputAmount(double outputAmount) {
		this.outputAmount = outputAmount;
	}

}
