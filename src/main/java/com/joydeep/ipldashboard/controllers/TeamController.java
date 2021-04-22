package com.joydeep.ipldashboard.controllers;

import com.joydeep.ipldashboard.daos.TeamDao;
import com.joydeep.ipldashboard.domains.Team;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private final TeamDao<Team> teamsDao;

    public TeamController(TeamDao<Team> teamsDao) {
        this.teamsDao = teamsDao;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        return teamsDao.findByName(teamName);
    }
}
