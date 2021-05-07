import { React, useEffect, useState } from 'react';
import { MatchCardDetail } from './MatchCardDetail';
import { MatchSmallDetail } from './MatchSmallDetail';
import {useParams} from 'react-router-dom'
import './TeamPage.css'

export const TeamPage = () => {

  const [team,setTeam] = useState({matches: []});
  const {teamName} = useParams();
  useEffect(
    () => {
      const fetchMatches = async () => {
          const response = await fetch(`http://localhost:9090/team/${teamName}`)
          const data = await response.json();
          console.log(data);
          setTeam(data);
      };
      fetchMatches();
    },[teamName]
  );
  if(!team || !team.teamName)
    return <h1>Team not found</h1>
  return (
    <div className="TeamPage">
      <h1>{team.teamName}</h1>
      <MatchCardDetail  match={team.matches[0]} team1Name={team.matches[0].team1}/>
      {team.matches.slice(1).map(match => <MatchSmallDetail match={match} team1Name={match.team1}/>)}
    </div>
  );
}

