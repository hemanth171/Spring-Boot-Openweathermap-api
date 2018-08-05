package com.hemanth.weatherserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(WeatherAppProperties.class)
public class WeatherservApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherservApplication.class, args);
	}
}
