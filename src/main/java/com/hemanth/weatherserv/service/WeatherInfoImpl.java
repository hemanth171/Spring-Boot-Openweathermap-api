package com.hemanth.weatherserv.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemanth.weatherserv.api.WeatherInfo;
import com.hemanth.weatherserv.model.WeatherSearchObject;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Scope("request")
public class WeatherInfoImpl implements WeatherInfo {

    private final WeatherService weatherService;

    public WeatherInfoImpl(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public <T> T getWeatherInfo(@RequestBody String searchJson) {
        WeatherSearchObject weatherSearchObject;
        try {
            weatherSearchObject = new ObjectMapper().readValue(searchJson, WeatherSearchObject.class);
            System.out.println(weatherSearchObject.getCity() + " " + weatherSearchObject.getCountry());
            return (T) this.weatherService.getWeather(weatherSearchObject.getCity(), weatherSearchObject.getCountry());
        } catch (Exception e) {
            return (T) new ResponseEntity<>("Error in connecting to server", HttpStatus.BAD_REQUEST);
        }
    }
}
