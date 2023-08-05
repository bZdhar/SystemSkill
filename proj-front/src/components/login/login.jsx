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
    username: "",
    password: localStorage.getItem("senha")?localStorage.getItem("senha"):"",
    passwordRegister: "",
    passwordConfirm: "",
    showPassword: false,
  });


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


  const handleEntrar = () => {
    console.log(values.password)
    console.log(rememberBox)
    if (rememberBox == true) { 
        localStorage.setItem("senha", values.password);
    }    
    else {
        localStorage.removeItem("senha");
    }
    
    localStorage.setItem("rememberBox",rememberBox);

    const data = {
        username: values.userName,
        password: values.password
    };

    // fetch('https://exemplo.com/api/login', {
    //         method: 'POST',
    //         headers: {
    //           'Content-Type': 'application/json'
    //         },
    //         body: JSON.stringify(data)
    //       })
    //       .then(response => {
    //         if (response.ok) {
    //           return response.json();
    //         } else {
    //           throw new Error('Erro na resposta da API');
    //         }
    //       })
    //       .then(data => {
    //         // Faça algo com os dados recebidos (exemplo: redirecionar para uma página interna)
    //         console.log('Login bem-sucedido:', data);
    //       })
    //       .catch(error => {
    //         // Trate os erros aqui
    //         console.error('Erro ao fazer login:', error);
    //       });
    //     };
    navigate("home");
  }


  
  const handleRegisterPassword = () => {
    setValues({ ...values, showPassword: !values.showPassword });
  };

  const handleClickShowRegisterPassword = () => {
    setValues({ ...values, showPassword: !values.showPassword });
    setEyeRegister(!eyeIsClosedRegister)
  };


  const handleConfirmPassword = () => {
    setValues({ ...values, showPassword: !values.showPassword });
  };

  const handleClickShowConfirmPassword = () => {
    setValues({ ...values, showPassword: !values.showPassword });
    setEyeConfirm(!eyeIsClosedConfirm)
  };


  return (
    <div>
      <div className="login">
        <form className="form">
          <label htmlFor="chk">Faça seu login!</label>
          <br />
          <input
            className="input"
            value={values.userName}
            type="email"
            name="email"
            placeholder="Nome do usuário"
            required=""
          />
          <br />
          <InputGroup>
            <input
              onChange={(event) => handlePasswordChange(event)}
              id="pswd"
              value={values.password}
              type={values.showPassword ? "text" : "password"}
              name="pswd"
              placeholder="Inserir sua senha"
              required=""
            />
            <div className="input-group-append">
            <button
              className="btn btn-outline-secondary"
              id="eye"
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
          onClick={handleEntrar}
          > Entrar!
          </button>
        </form>
      </div>
      
      <br />

      <div className="register">
        <form className="form">
          <label htmlFor="chk" aria-hidden="true">
            Cadastre-se
          </label>
          <br />
          <input
            className="input"
            type="text"
            name="txt"
            placeholder="Nome de Usuário"
            required=""
          />
          <br />
          <input
            className="input"
            type="email"
            name="email"
            placeholder="Email"
            required=""
          />
          <br />
          <input
            onChange={(event) => handleRegisterPassword(event)}
            value={values.passwordRegister}
            type={values.showRegisterPassword ? "text" : "password"}
            className="input"
            name="pswd"
            placeholder="Senha"
            required=""
          />
          <div className="input-group-append">
            <button
              className="btn btn-outline-secondary"
              id="eye"
              onClick={(event) => {
                event.preventDefault();
                handleClickShowRegisterPassword();
              }}
            >
              {eyeIsClosedRegister ? <VscEyeClosed /> : <VscEye />}
            </button>
            </div>
          <br />
          <input
            onChange={(event) => handleConfirmPassword(event)}
            value={values.passwordConfirm}
            type={values.showConfirmPassword ? "text" : "password"}            
            className="input"
            type="password"
            name="pswd"
            placeholder="Confirme a Senha"
            required=""
          />
          <div className="input-group-append">
            <button
              className="btn btn-outline-secondary"
              id="eye"
              onClick={(event) => {event.preventDefault();
              handleClickShowConfirmPassword();
              }}
            >
              {eyeIsClosedConfirm ? <VscEyeClosed /> : <VscEye />}
            </button>
            </div>
          <br />
          <button>Cadastrar</button>
        </form>
      </div>
    </div>
  );
}

export default Login;
