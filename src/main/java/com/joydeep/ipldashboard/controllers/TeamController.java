package com.joydeep.ipldashboard.controllers;

import com.joydeep.ipldashboard.daos.TeamDao;
import com.joydeep.ipldashboard.domains.Match;
import com.joydeep.ipldashboard.domains.Team;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {

    private final TeamDao<Team,Match> teamsDao;

    public TeamController(TeamDao<Team,Match> teamsDao) {
        this.teamsDao = teamsDao;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        return teamsDao.findByName(teamName);
    }
    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesByTeamAndYear(@PathVariable String teamName, @RequestParam int year)
    {
    	return teamsDao.findByNameAndYear(teamName, year);
    }
}
