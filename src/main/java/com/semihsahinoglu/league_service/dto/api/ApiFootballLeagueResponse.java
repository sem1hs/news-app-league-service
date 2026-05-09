package com.semihsahinoglu.league_service.dto.api;

import java.util.List;

public record ApiFootballLeagueResponse(
        List<ApiFootballLeagueWrapper> response
) {
}