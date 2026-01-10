package com.semihsahinoglu.league_service.controller;

import com.semihsahinoglu.league_service.service.LeagueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
