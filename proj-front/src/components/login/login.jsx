import React, { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import { VscEye, VscEyeClosed } from "react-icons/vsc";
import "./login.css";
import { InputGroup } from "react-bootstrap";

function Login() {
  const [eyeIsClosed, setEyeState] = useState(true);
  const [eyeIsClosedRegister, setEyeRegister] = useState (true);
  const [eyeIsClosedConfirm, setEyeConfirm] = useState (true)
  const [rememberBox, setRememberPassword] = useState(localStorage.getItem("rememberBox")=="true"?true: false);
  const navigate = useNavigate();

  const [values, setValues] = React.useState({
    username:"",
    password:localStorage.getItem("senha")?localStorage.getItem("senha"):"",
    passwordRegister:"",
    passwordConfirm:"",
    showPassword:false,
    showRegisterPassword:false,
    showConfirmPassword:false,
    passwordMatchError: ""
  });

  const handleUsuarioChange = (event) =>{
    setValues({...values, username: event.target.value});
  }

  const handleClickShowPassword = () => {
    setValues({ ...values, showPassword: !values.showPassword });
    setEyeState(!eyeIsClosed)
  };

  const handlePasswordChange = (event) => {
    setValues({ ...values, password: event.target.value});
  };

  const handleRememberBox = (event) => {
    setRememberPassword(event.target.checked);
  };

  const handleEntrar = async (event) => {
    event.preventDefault();
  
    if(values.username === '' | null && values.password === '' | null)
      return;

    if (rememberBox == true) { 
        localStorage.setItem("senha", values.password);
    }    
    else {
        localStorage.removeItem("senha");
    }
    
    localStorage.setItem("rememberBox",rememberBox);

    const data = {
        username: values.username,
        password: values.password
    };

    const response = await fetch("http://localhost:8080/systemskills/auth/login",{
      method:"POST",
      headers:{'Content-Type':'application/json'},
      body:JSON.stringify(data)
    });
    
    if(response.status === 200){
      const tokenResponse = await response.json();
      localStorage.setItem("token", tokenResponse.token);
      navigate("/home");
    }
  }

  const handleBtnRegister = () => {
    navigate ("/cadastro")
  }
  // const handleRegisterError = (event) => {
  //   if 
  // }
  return (
    <div className="main">
      <div className="login">
        <form className="form">
          <label htmlFor="chk" id="chk" aria-hidden="true"> Faça seu login!</label>
          <br />
          <input
            className="input"
            onChange={handleUsuarioChange}
            value={values.userName}
            type="email"
            placeholder="Nome do usuário"
            required=""
          />
          <br />
          <InputGroup>
            <input
              onChange={(event) => handlePasswordChange(event)}
              className="input"
              id="pswd"
              value={values.password}
              type={values.showPassword ? "text" : "password"}
              placeholder="Inserir sua senha"
              required=""
            />
            <div className="input-group-append">
            <button
              className="btn btn-outline-secondary"
              id="eyePassword"
              onClick={(event) => {
                event.preventDefault();
                handleClickShowPassword();
              }}
            >
              {eyeIsClosed ? <VscEyeClosed /> : <VscEye />}
            </button>
            </div>
          </InputGroup>
          <label>
            Lembrar-me:
            <input
              className="chkbox"
              type="checkbox"
              checked={rememberBox}
              onChange={handleRememberBox}
            />
          </label>
          <br />
          <button
          id="btnEntrar"
          onClick={handleEntrar}
          > Entrar!
          </button>
          <br />
          <button
          onClick={handleBtnRegister}
          id="btnCadastrar">
          Cadastrar-se
          </button>
        </form>
      </div>
    </div>
  );
}

export default Login;
