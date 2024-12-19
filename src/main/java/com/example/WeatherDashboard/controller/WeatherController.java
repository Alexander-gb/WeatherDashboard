package com.example.WeatherDashboard.controller;

import com.example.WeatherDashboard.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @GetMapping("api/weather")
    public Mono<String> getWeather(@RequestParam String city) {
        return weatherService.getWeather(city);
    }
}
