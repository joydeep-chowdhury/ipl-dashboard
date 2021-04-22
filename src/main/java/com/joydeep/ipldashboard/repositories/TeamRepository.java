package com.joydeep.ipldashboard.repositories;

import com.joydeep.ipldashboard.domains.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

    Team findByTeamName(String teamName);
}
