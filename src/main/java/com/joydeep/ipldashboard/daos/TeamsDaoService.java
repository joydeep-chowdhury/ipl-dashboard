package com.joydeep.ipldashboard.daos;

import com.joydeep.ipldashboard.domains.Match;
import com.joydeep.ipldashboard.domains.Team;
import com.joydeep.ipldashboard.repositories.MatchRepository;
import com.joydeep.ipldashboard.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamsDaoService implements TeamDao<Team> {
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final Map<String, Team> teamsMap;

    public TeamsDaoService(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        teamsMap = new LinkedHashMap<String, Team>();
    }

    @Override
    public void createTeams() {



        matchRepository.findTeam1Statistics()
                       .stream()
                       .map(match -> {
                           if (match[0] != null && match[1] != null) {
                               String teamName = (String) match[0];
                               BigInteger matchCount = (BigInteger) match[1];
                               Team team = new Team(teamName);
                               team.setTotalMatches(matchCount.longValue());
                               return team;
                           }
                           return null;
                       })
                       .forEach(team -> {
                           if (team != null) {
                               teamsMap.put(team.getTeamName(), team);
                           }
                       });

        matchRepository.findTeam2Statistics()
                       .stream()
                       .forEach(match -> {
                           if (match[0] != null && match[1] != null) {
                               String teamName = (String) match[0];
                               BigInteger matchCount = (BigInteger) match[1];
                               if (teamsMap.containsKey(teamName)) {
                                   Team team = teamsMap.get(teamName);
                                   team.setTotalMatches(team.getTotalMatches() + matchCount.longValue());
                               } else {
                                   Team team = new Team(teamName);
                                   teamsMap.put(teamName, team);
                               }
                           }

                       });

/*        matchRepository.findWinStatistics()
                       .stream()
                       .forEach(match -> {
                           if (match[0] != null && match[1] != null) {
                               String teamName = (String) match[0];
                               BigInteger winCount = (BigInteger) match[1];
                               Team team = teamsMap.get(teamName);
                               team.setTotalWins(winCount.longValue());
                           }
                       });*/
        List<Match> matches=matchRepository.findAll();
        teamsMap.keySet().forEach(teamName->{
            Team team = teamsMap.get(teamName);
            long totalWIns=matches.stream().filter(match -> match.getMatchWinner().equals(teamName)).count();
            team.setTotalWins(totalWIns);
        });

        teamsMap.values().forEach(team -> {
            teamRepository.save(team);
        });

    }

    @Override
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }
}