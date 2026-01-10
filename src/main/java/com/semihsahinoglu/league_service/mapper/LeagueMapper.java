package com.semihsahinoglu.league_service.mapper;

import com.semihsahinoglu.league_service.dto.LeagueCreateRequest;
import com.semihsahinoglu.league_service.dto.LeagueResponse;
import com.semihsahinoglu.league_service.dto.LeagueUpdateRequest;
import com.semihsahinoglu.league_service.entity.League;
import org.springframework.stereotype.Component;

@Component
public class LeagueMapper {

    public League toEntity(LeagueCreateRequest leagueCreateRequest) {
        if (leagueCreateRequest == null) return null;

        return League.builder()
                .name(leagueCreateRequest.name())
                .country(leagueCreateRequest.country())
                .logoUrl(leagueCreateRequest.logoUrl())
                .build();
    }

    public LeagueResponse toDto(League league) {
        if (league == null) return null;

        return LeagueResponse.builder()
                .id(league.getId())
                .name(league.getName())
                .country(league.getCountry())
                .logoUrl(league.getLogoUrl())
                .build();
    }

    public void updateEntity(League league, LeagueUpdateRequest leagueUpdateRequest) {
        leagueUpdateRequest.name().ifPresent(league::setName);
        leagueUpdateRequest.country().ifPresent(league::setCountry);
        leagueUpdateRequest.logoUrl().ifPresent(league::setLogoUrl);
    }
}
