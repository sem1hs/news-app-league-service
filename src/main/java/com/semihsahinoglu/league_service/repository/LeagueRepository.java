package com.semihsahinoglu.league_service.repository;

import com.semihsahinoglu.league_service.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {

    Optional<League> findByExternalId(Long externalId);

    Optional<League> findByName(String leagueName);

    Optional<League> findByCountry(String country);
}
