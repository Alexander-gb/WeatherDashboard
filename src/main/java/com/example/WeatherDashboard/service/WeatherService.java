package com.example.WeatherDashboard.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class WeatherService {

    private final String apiUrl;
    private final String apiKey;
    private final WebClient webClient;

    public WeatherService(@Value("${weather.api.url}") String apiUrl,
                          @Value("${weather.api.key}") String apiKey,
                          WebClient.Builder webClientBuilder) {
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
        this.webClient = webClientBuilder.baseUrl(apiUrl).build();
    }
    public Mono<String> getWeather(String city) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("")
                        .queryParam("q", city)
                        .queryParam("appid", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}