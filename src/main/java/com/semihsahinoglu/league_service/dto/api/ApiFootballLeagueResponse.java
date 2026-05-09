package com.semihsahinoglu.league_service.dto.api;

import java.util.List;

public class ApiFootballLeagueResponse {

    private List<ApiFootballLeagueWrapper> response;

    public List<ApiFootballLeagueWrapper> getResponse() {
        return response;
    }

    public void setResponse(List<ApiFootballLeagueWrapper> response) {
        this.response = response;
    }
}