import { React,useEffect,useState} from 'react';
import { MatchCardDetail } from './MatchCardDetail';
import {useParams} from 'react-router-dom'

export const MatchPage = () => {

  const[matches,setMatches] = useState([]);
  const {teamName,year} = useParams();
  useEffect(
    () => {
      const fetchMatches = async () => {
          const response = await fetch(`http://localhost:9090/team/${teamName}/matches?year=${year}`)
          const data = await response.json();
          console.log(data);
          setMatches(data);
      };
      fetchMatches();
    },[]
  );

  return (
    <div className="MatchPage">
      <h1>Match Page</h1>
      {
          matches.map(match=><MatchCardDetail team1Name={teamName} match={match}/>)
      }
    </div>
  );
}

