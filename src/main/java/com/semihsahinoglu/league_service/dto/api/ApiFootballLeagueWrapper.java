package com.semihsahinoglu.league_service.dto.api;

public record ApiFootballLeagueWrapper(
        ApiFootballLeagueDto league,
        ApiFootballCountryDto country
) {
}