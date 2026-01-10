package com.semihsahinoglu.league_service.repository;

import com.semihsahinoglu.league_service.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
}
