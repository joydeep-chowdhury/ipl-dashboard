package com.joydeep.ipldashboard.repositories;

import com.joydeep.ipldashboard.domains.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    @Query(nativeQuery = true, value = "SELECT team1 , COUNT(*) from Match GROUP BY team1")
    List<Object[]> findTeam1Statistics();

    @Query(nativeQuery = true, value = "SELECT team2 , COUNT(*) from Match GROUP BY team2")
    List<Object[]> findTeam2Statistics();

    @Query(nativeQuery = true, value = "SELECT matchWinner , COUNT(*) from Match GROUP BY matchWinner")
    List<Object[]> findWinStatistics();

}
