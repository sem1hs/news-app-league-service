package com.semihsahinoglu.league_service.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiFootballLeagueDto {

    private Long id;

    private String name;

    @JsonProperty("logo")
    private String logoUrl;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}