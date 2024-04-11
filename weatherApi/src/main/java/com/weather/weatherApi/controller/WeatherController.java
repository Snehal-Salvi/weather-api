package com.weather.weatherApi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class WeatherController {

    @Value("${rapidapi.key}")
    private String rapidApiKey;

    // Endpoint to get the weather forecast summary for a city
    @GetMapping("/forecast-summary")
    public String getForecastSummary(@RequestParam String city) {
        // API URL for weather forecast summary
        String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/" + city + "/summary/";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");

        // Create HTTP entity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Send GET request to the API
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // Return response body
        return response.getBody();
    }

    // Endpoint to get hourly weather forecast details for a city
    @GetMapping("/hourly-forecast")
    public String getHourlyForecast(@RequestParam String city) {
        // API URL for hourly weather forecast
        String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/" + city + "/hourly/";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");

        // Create HTTP entity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Send GET request to the API
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // Return response body
        return response.getBody();
    }
}
