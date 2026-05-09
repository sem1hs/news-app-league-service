package com.semihsahinoglu.league_service.service;

import com.semihsahinoglu.league_service.client.FootballLeagueApiClient;
import com.semihsahinoglu.league_service.dto.api.ApiFootballCountryDto;
import com.semihsahinoglu.league_service.dto.api.ApiFootballLeagueDto;
import com.semihsahinoglu.league_service.dto.api.ApiFootballLeagueResponse;
import com.semihsahinoglu.league_service.dto.api.ApiFootballLeagueWrapper;
import com.semihsahinoglu.league_service.entity.League;
import com.semihsahinoglu.league_service.exception.LeagueNotFoundException;
import com.semihsahinoglu.league_service.mapper.LeagueMapper;
import com.semihsahinoglu.league_service.repository.LeagueRepository;
import org.springframework.stereotype.Service;

@Service
public class LeagueSyncService {

    private final LeagueRepository leagueRepository;
    private final LeagueMapper leagueMapper;
    private final FootballLeagueApiClient footballApiClient;

    public LeagueSyncService(LeagueRepository leagueRepository, LeagueMapper leagueMapper, FootballLeagueApiClient footballApiClient) {
        this.leagueRepository = leagueRepository;
        this.leagueMapper = leagueMapper;
        this.footballApiClient = footballApiClient;
    }

    public League syncLeague(String leagueName, int season) {
        ApiFootballLeagueResponse response = footballApiClient.getLeague(leagueName, season);

        if (response == null || response.response() == null || response.response().isEmpty())
            throw new LeagueNotFoundException("Lig bulunamadı : " + leagueName);

        ApiFootballLeagueWrapper wrapper = response.response().getFirst();
        ApiFootballLeagueDto apiLeague = wrapper.league();
        ApiFootballCountryDto country = wrapper.country();

        League league = leagueMapper.toEntity(apiLeague, country);
        return leagueRepository.save(league);
    }

    public League syncLeagueByCountry(String countryName, int season) {
        ApiFootballLeagueResponse response = footballApiClient.getLeagueByCountry(countryName, season);

        if (response == null || response.response() == null || response.response().isEmpty())
            throw new LeagueNotFoundException("Lig bulunamadı : " + countryName);

        ApiFootballLeagueWrapper wrapper = response.response().getFirst();
        ApiFootballLeagueDto apiLeague = wrapper.league();
        ApiFootballCountryDto country = wrapper.country();

        League league = leagueMapper.toEntity(apiLeague, country);
        return leagueRepository.save(league);
    }

    public League syncLeague(Long externalId, int season) {

        ApiFootballLeagueResponse response = footballApiClient.getLeague(externalId, season);

        if (response == null || response.response() == null || response.response().isEmpty())
            throw new LeagueNotFoundException("Lig bulunamadı : " + externalId);

        ApiFootballLeagueWrapper wrapper = response.response().getFirst();
        ApiFootballLeagueDto apiLeague = wrapper.league();
        ApiFootballCountryDto country = wrapper.country();

        League league = leagueMapper.toEntity(apiLeague, country);
        return leagueRepository.save(league);
    }
}
