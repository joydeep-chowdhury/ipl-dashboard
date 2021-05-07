import { React } from 'react';
import './MatchSmallDetail.css'
import {Link} from 'react-router-dom'

export const MatchSmallDetail = ({team1Name,match})=> {
  const team2Name= team1Name===match.team1 ? match.team2:match.team1; 
  const team2Route=`/teams/${team2Name}`
  return (
    <div className="MatchSmallDetail">
        <h3>vs <Link to={team2Route}>{team2Name}</Link></h3>
        <p>{match.matchWinner} won by {match.resultMargin} {match.result}</p>
    </div>
  );
}
