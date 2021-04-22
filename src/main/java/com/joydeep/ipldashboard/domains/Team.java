package com.joydeep.ipldashboard.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String teamName;
    private long totalMatches;
    private long totalWins;
    @Transient
    private List<Match> mathes;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team() {

    }

    public long getId() {
        return id;
    }

    public List<Match> getMathes() {
        return mathes;
    }

    public void setMathes(List<Match> mathes) {
        this.mathes = mathes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(long totalMatches) {
        this.totalMatches = totalMatches;
    }

    public long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(long totalWins) {
        this.totalWins = totalWins;
    }

    @Override
    public String toString() {
        return "Team{" + "id=" + id + ", teamName='" + teamName + '\'' + ", totalMatches=" + totalMatches + ", totalWins=" + totalWins + ", mathes=" + mathes + '}';
    }
}
