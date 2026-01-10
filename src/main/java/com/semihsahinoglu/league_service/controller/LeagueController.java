package com.semihsahinoglu.league_service.controller;

import com.semihsahinoglu.league_service.dto.LeagueCreateRequest;
import com.semihsahinoglu.league_service.dto.LeagueResponse;
import com.semihsahinoglu.league_service.dto.LeagueUpdateRequest;
import com.semihsahinoglu.league_service.service.LeagueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/league")
public class LeagueController {

    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping
    public ResponseEntity<List<LeagueResponse>> getAllLeagues() {
        List<LeagueResponse> leagues = leagueService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(leagues);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeagueResponse> getLeagueById(@PathVariable Long id) {
        LeagueResponse league = leagueService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(league);
    }

    @PostMapping
    public ResponseEntity<LeagueResponse> createLeague(@Valid @RequestBody LeagueCreateRequest request) {
        LeagueResponse league = leagueService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(league);
    }

    @PatchMapping("/{id}")
    ResponseEntity<LeagueResponse> update(@PathVariable Long id, @RequestBody LeagueUpdateRequest leagueUpdateRequest) {
        LeagueResponse leagueResponse = leagueService.update(id, leagueUpdateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(leagueResponse);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        leagueService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
