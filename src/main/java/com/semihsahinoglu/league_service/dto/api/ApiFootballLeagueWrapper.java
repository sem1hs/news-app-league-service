package com.semihsahinoglu.league_service.dto.api;

public class ApiFootballLeagueWrapper {

    private ApiFootballLeagueDto league;

    private ApiFootballCountryDto country;

    public ApiFootballLeagueDto getLeague() {
        return league;
    }

    public void setLeague(ApiFootballLeagueDto league) {
        this.league = league;
    }

    public ApiFootballCountryDto getCountry() {
        return country;
    }

    public void setCountry(ApiFootballCountryDto country) {
        this.country = country;
    }
}