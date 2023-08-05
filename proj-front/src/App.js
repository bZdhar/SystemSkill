import logo from './logo.svg';
import Login from './components/login/login';
import Home from './components/home/home'
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element = {<Login/>}>
          <Route path="home" element={<Home/>}/>
        </Route>
      </Routes>
    </BrowserRouter>

  );
}

export default App;
