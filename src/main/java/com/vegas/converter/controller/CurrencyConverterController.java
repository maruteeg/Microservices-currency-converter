package com.vegas.converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegas.converter.adapter.CurrencyRateAdapter;
import com.vegas.converter.bo.CurrencyConverter;
import com.vegas.converter.service.proxy.CurrencyRateServiceProxy;

@RestController
@RequestMapping("/currency-converter/")
public class CurrencyConverterController {

	@Autowired
	CurrencyRateAdapter currencyRateAdapter;

	@Autowired
	CurrencyRateServiceProxy currencyRateServiceProxy;

	@PostMapping("/")
	CurrencyConverter convertCurrency(@RequestBody CurrencyConverter currencyConverter) {
		double rate = currencyRateAdapter.getCurrencyRate(currencyConverter.getSourceCountryCode(),
				currencyConverter.getTargetCountryCode());
		currencyConverter.setOutputAmount(rate * currencyConverter.getInputAmount());
		return currencyConverter;
	}

	@PostMapping("/fein/")
	CurrencyConverter convertCurrencyFein(@RequestBody CurrencyConverter currencyConverter) {
		double rate = Double.valueOf(currencyRateServiceProxy.getCurrencyRate(currencyConverter.getSourceCountryCode(),
				currencyConverter.getTargetCountryCode()));
		currencyConverter.setOutputAmount(rate * currencyConverter.getInputAmount());
		return currencyConverter;
	}
}
