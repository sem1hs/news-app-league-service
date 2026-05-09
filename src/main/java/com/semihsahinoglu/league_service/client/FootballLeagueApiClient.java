package com.semihsahinoglu.league_service.client;

import com.semihsahinoglu.league_service.dto.api.ApiFootballLeagueResponse;
import com.semihsahinoglu.league_service.exception.LeagueNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FootballLeagueApiClient {

    private final WebClient footballWebClient;

    public FootballLeagueApiClient(WebClient footballWebClient) {
        this.footballWebClient = footballWebClient;
    }

    public ApiFootballLeagueResponse getLeague(String leagueName, int season) {

        return footballWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/leagues")
                        .queryParam("name", leagueName)
                        .queryParam("season", season)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new LeagueNotFoundException("Lig bulunamadı : " + leagueName)))
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.error(new RuntimeException("Football API currently unavailable")))
                .bodyToMono(ApiFootballLeagueResponse.class)
                .block();
    }

    public ApiFootballLeagueResponse getLeagueByCountry(String countryName, int season) {

        return footballWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/leagues")
                        .queryParam("country", countryName)
                        .queryParam("season", season)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new LeagueNotFoundException("Lig bulunamadı : " + countryName)))
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.error(new RuntimeException("Football API currently unavailable")))
                .bodyToMono(ApiFootballLeagueResponse.class)
                .block();
    }

    public ApiFootballLeagueResponse getLeague(Long externalId, int season) {

        return footballWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/leagues")
                        .queryParam("id", externalId)
                        .queryParam("season", season)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new LeagueNotFoundException("Lig bulunamadı : " + externalId)))
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.error(new RuntimeException("Football API currently unavailable")))
                .bodyToMono(ApiFootballLeagueResponse.class)
                .block();
    }
}
