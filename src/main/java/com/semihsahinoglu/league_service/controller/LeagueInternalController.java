package com.semihsahinoglu.league_service.controller;

import com.semihsahinoglu.league_service.dto.LeagueResponse;
import com.semihsahinoglu.league_service.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/league")
public class LeagueInternalController {

    private final LeagueService leagueService;

    public LeagueInternalController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/{id}/exists")
    public Boolean existsById(@PathVariable Long id) {
        return leagueService.existsById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeagueResponse> getLeagueById(@PathVariable Long id) {
        LeagueResponse league = leagueService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(league);
    }

    @GetMapping("/external/{id}")
    public ResponseEntity<LeagueResponse> getLeagueByExternalId(@PathVariable Long id, @RequestParam(defaultValue = "2025") int season) {
        LeagueResponse league = leagueService.getByExternalId(id, season);
        return ResponseEntity.status(HttpStatus.OK).body(league);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<LeagueResponse> getLeagueByCountry(@PathVariable String country, @RequestParam(defaultValue = "2025") int season) {
        LeagueResponse league = leagueService.getByCountry(country, season);
        return ResponseEntity.ok(league);
    }
}
