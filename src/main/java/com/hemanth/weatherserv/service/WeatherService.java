package com.hemanth.weatherserv.service;

import com.hemanth.weatherserv.WeatherAppProperties;
import com.hemanth.weatherserv.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class WeatherService {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    private final RestTemplate restTemplate;

    private final String apiKey;

    public WeatherService(RestTemplateBuilder restTemplateBuilder, WeatherAppProperties weatherAppProperties) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiKey = weatherAppProperties.getApi().getKey();
    }

    public Weather getWeather(String city, String country) {
        logger.info("Requesting weather for {}/{}", city, country);
        URI url = new UriTemplate(WEATHER_URL).expand(city, country, this.apiKey);
        logger.info("Url: " + url.toString());
        return invoke(url, Weather.class);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        try {
            ResponseEntity<T> response = this.restTemplate.exchange(request, responseType);
            logger.info("Status code: " + response.getStatusCode().toString());
            return (T) response.getBody();
        } catch (HttpClientErrorException ex) {
            logger.error(ex.getStatusCode() + " " + ex.getStatusText());
            throw ex;
        }
    }
}
