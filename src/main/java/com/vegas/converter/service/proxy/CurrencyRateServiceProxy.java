package com.vegas.converter.service.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vegas.converter.config.FeinClientConfiguration;

@FeignClient(name = "forex-service", configuration = FeinClientConfiguration.class)
@RibbonClient(name = "forex-service")
public interface CurrencyRateServiceProxy {

	@GetMapping("forex/rate/{sourceCountryCode}/{targetCountryCode}")
	public String getCurrencyRate(@PathVariable("sourceCountryCode") String sourceCountryCode,
			@PathVariable("targetCountryCode") String targetCountryCode);
}
