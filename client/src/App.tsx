import React from 'react';
import logo from './logo.svg';
import axios from 'axios';
import './App.css';
import { RouterProvider, createBrowserRouter} from 'react-router-dom';
import { router } from './components/Router'

function App() {
 
  return(
    <div>
      <RouterProvider router={router}/>
    </div>
  )
}

export default App;
