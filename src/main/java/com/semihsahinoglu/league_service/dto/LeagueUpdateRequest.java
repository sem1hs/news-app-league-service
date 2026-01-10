package com.semihsahinoglu.league_service.dto;

import java.util.Optional;

public record LeagueUpdateRequest(
        Optional<String> name,
        Optional<String> country,
        Optional<String> logoUrl
) {
}
