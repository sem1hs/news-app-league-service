package com.semihsahinoglu.league_service.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ApiFootballLeagueDto(
        Long id,
        String name,
        @JsonProperty("logo")
        String logoUrl
) {
}