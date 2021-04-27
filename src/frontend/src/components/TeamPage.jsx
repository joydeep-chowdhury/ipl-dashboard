import { React } from 'react';
import {MatchCardDetail} from './MatchCardDetail'
import {MatchSmallDetail} from './MatchSmallDetail'
import './TeamPage.css'

export const TeamPage = ()=> {
  return (
    <div className="TeamPage">
        <h1>Team Name</h1>
        <MatchCardDetail/>
        <MatchSmallDetail/>
        <MatchSmallDetail/>
        <MatchSmallDetail/>
    </div>
  );
}

