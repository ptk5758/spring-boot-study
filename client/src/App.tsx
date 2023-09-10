import React from 'react';
import logo from './logo.svg';
import axios from 'axios';
import './App.css';

function App() {

  axios.defaults.withCredentials = true
  document.cookie = "asdf=ptk; path=/"
  
  const requestDev = async () => {
    axios.get("/dev")
    .then(res => {console.log(res)});
    
  }

  const requestCookie = async () => {
    axios.post("/dev")
    .then(res=>{console.log(res)});
  } 
  return(
    <div>
      sadsa
      <button onClick={requestDev}>요청!</button><br/>
      <button onClick={requestCookie}>쿠키 요청!</button><br/>
    </div>
  )
}

export default App;
