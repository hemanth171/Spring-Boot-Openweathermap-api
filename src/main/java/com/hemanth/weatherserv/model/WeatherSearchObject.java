package com.hemanth.weatherserv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"city", "country"})
public class WeatherSearchObject {

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    public WeatherSearchObject() {}

    public WeatherSearchObject(String city, String country) {
        super();
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
