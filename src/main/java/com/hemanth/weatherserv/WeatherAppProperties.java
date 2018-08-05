package com.hemanth.weatherserv;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ConfigurationProperties("app.weather")
public class WeatherAppProperties {

    @Valid
    private final Api api = new Api();

    public Api getApi() {
        return api;
    }

    public static class Api {

        @NotNull
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
