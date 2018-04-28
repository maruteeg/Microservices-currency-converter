package com.vegas.converter.bo;

public class CurrencyRate {
	private String sourceCountryCode;
	private String targetCountryCode;
	private double conversionRate;

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

	public double getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}


}
