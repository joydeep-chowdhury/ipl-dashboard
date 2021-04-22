package com.joydeep.ipldashboard.processors;

import com.joydeep.ipldashboard.domains.Match;
import com.joydeep.ipldashboard.domains.MatchInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import static com.joydeep.ipldashboard.utils.MatchUtils.assignTeams;
import static com.joydeep.ipldashboard.utils.MatchUtils.stringToLocalDate;
import static com.joydeep.ipldashboard.utils.MatchUtils.stringToLong;

import java.time.LocalDate;

public class MatchProcessor implements ItemProcessor<MatchInput, Match> {
    private static final Logger logger = LoggerFactory.getLogger(MatchProcessor.class);

    @Override
    public Match process(MatchInput matchInput) throws Exception {
        Match match = new Match();
        match.setId(stringToLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(stringToLocalDate(matchInput.getDate()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());
        String tossDecision = matchInput.getToss_decision();
        String tossWinner = matchInput.getToss_winner();
        assignTeams(match, matchInput);
        match.setMatchWinner(matchInput.getWinner());
        match.setTossWinner(tossWinner);
        match.setTossDecision(tossDecision);
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());

        return match;
    }
}
