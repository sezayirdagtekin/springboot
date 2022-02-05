package com.sezo.demo.config;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//Experimental study.
//@Configuration
public class DateTimeConfig   extends WebMvcConfigurationSupport{
	
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final String DATE_FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

	@Override
	public FormattingConversionService mvcConversionService() {
		 DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

	        DateTimeFormatterRegistrar dateTimeRegistrar = new DateTimeFormatterRegistrar();
	        dateTimeRegistrar.setDateFormatter(DateTimeFormatter.ofPattern(DATE_FORMAT));
	        dateTimeRegistrar.setDateTimeFormatter(DateTimeFormatter.ofPattern(DATE_FORMAT_TIME));
	        dateTimeRegistrar.registerFormatters(conversionService);

	        DateFormatterRegistrar dateRegistrar = new DateFormatterRegistrar();
	        dateRegistrar.setFormatter(new DateFormatter(DATE_FORMAT));
	        dateRegistrar.registerFormatters(conversionService);

	        return conversionService;
	}	
}
