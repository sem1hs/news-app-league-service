package com.semihsahinoglu.league_service.service;

import com.semihsahinoglu.league_service.dto.LeagueCreateRequest;
import com.semihsahinoglu.league_service.dto.LeagueResponse;
import com.semihsahinoglu.league_service.dto.LeagueUpdateRequest;
import com.semihsahinoglu.league_service.entity.League;
import com.semihsahinoglu.league_service.exception.LeagueNotFoundException;
import com.semihsahinoglu.league_service.mapper.LeagueMapper;
import com.semihsahinoglu.league_service.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;
    private final LeagueMapper leagueMapper;
    private final LeagueSyncService leagueSyncService;

    public LeagueService(LeagueRepository leagueRepository, LeagueMapper leagueMapper, LeagueSyncService leagueSyncService) {
        this.leagueRepository = leagueRepository;
        this.leagueMapper = leagueMapper;
        this.leagueSyncService = leagueSyncService;
    }

    public LeagueResponse getById(Long id) {
        League league = leagueRepository.findById(id).orElseThrow(() -> new LeagueNotFoundException("Lig bulunamadı " + id));
        return leagueMapper.toDto(league);
    }

    public LeagueResponse getByExternalId(Long externalId, int season) {
        League league = leagueRepository.findByExternalId(externalId).orElseGet(() -> leagueSyncService.syncLeague(externalId, season));
        return leagueMapper.toDto(league);
    }

    public LeagueResponse getByName(String leagueName, int season) {
        League league = leagueRepository.findByName(leagueName).orElseGet(() -> leagueSyncService.syncLeague(leagueName, season));
        return leagueMapper.toDto(league);
    }

    public LeagueResponse getByCountry(String country, int season) {
        League league = leagueRepository.findByCountry(country).orElseGet(() -> leagueSyncService.syncLeagueByCountry(country, season));
        return leagueMapper.toDto(league);
    }

    public List<LeagueResponse> getAll() {
        List<League> leagueList = leagueRepository.findAll();
        return leagueList.stream().map(leagueMapper::toDto).toList();
    }

    public LeagueResponse create(LeagueCreateRequest leagueCreateRequest) {
        League league = leagueMapper.toEntity(leagueCreateRequest);
        League savedLeague = leagueRepository.save(league);
        return leagueMapper.toDto(savedLeague);
    }

    public LeagueResponse update(Long id, LeagueUpdateRequest leagueUpdateRequest) {
        League league = leagueRepository.findById(id).orElseThrow(() -> new LeagueNotFoundException("Lig bulunamadı " + id));
        leagueMapper.updateEntity(league, leagueUpdateRequest);
        League updatedLeague = leagueRepository.save(league);
        return leagueMapper.toDto(updatedLeague);
    }

    public void delete(Long id) {
        League league = leagueRepository.findById(id).orElseThrow(() -> new LeagueNotFoundException("Lig bulunamadı " + id));
        leagueRepository.delete(league);
    }

    public Boolean existsById(Long id) {
        return leagueRepository.existsById(id);
    }
}