import logo from './logo.svg';
import Login from './components/login/login';
import Home from './components/home/home'
import Cadastro from './components/cadastro/cadastro';
import { BrowserRouter, Route, Routes } from 'react-router-dom';



function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element = {<Login/>}/>
        <Route path="/cadastro" element={<Cadastro/>}/>
        <Route path="/home" element={<Home/>}/>
        <Route path="/*" element={<Login/>}/>
      </Routes>
    </BrowserRouter>

  );
}

export default App;
