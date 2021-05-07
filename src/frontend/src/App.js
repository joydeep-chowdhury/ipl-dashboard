import logo from './logo.svg';
import './App.css';

import {TeamPage} from './components/TeamPage'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import { MatchPage } from './components/MatchPage';


function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
        <Route path="/teams/:teamName/matches/:year">
               <MatchPage/>
         </Route>
         <Route path="/teams/:teamName">
               <TeamPage/>
         </Route>
         </Switch>
      </Router>
      
    </div>
  );
}

export default App;


