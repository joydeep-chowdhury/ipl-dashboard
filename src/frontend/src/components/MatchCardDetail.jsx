import { React } from 'react';
import './MatchCardDetail.css'
import {Link} from 'react-router-dom'

export const MatchCardDetail = ({match,team1Name})=> {
  const team2Name= team1Name===match.team1 ? match.team2:match.team1; 
  const team2Route=`/teams/${team2Name}`
  if(!match) return null;
  return (
    <div className="MatchCardDetail">
        <h2>Latest Matches</h2>
        <h1>vs <Link to={team2Route}>{team2Name}</Link></h1>
        <h2>{match.date}</h2>
        <h3>at {match.venue}</h3>
        <h3>{match.matchWinner} won by {match.resultMargin} {match.result}</h3>
    </div>
  );
}

