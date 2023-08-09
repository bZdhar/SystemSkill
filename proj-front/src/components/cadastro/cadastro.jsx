import React, { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import { VscEye, VscEyeClosed } from "react-icons/vsc";
import "../../../src/./index.css";
import "./cadastro.css";
import { InputGroup } from "react-bootstrap";

function Cadastro() {
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
    validationError: ""
  });

  function Validar (){
    // let retorno = (true)
    if (values.userName === "") {
      setValues({...values,validationError:"Por favor, preencha o Nome de Usuário"})
      return (false)
    }
    if (values.passwordRegister === "") {
      setValues({...values, validationError: "Por favor, preencha a senha antes de continuar."})
      return (false)
    }
    if (values.passwordConfirm === ""){
      setValues({...values, validationError: "Por favor, preencha a  confirmação da senha antes de continuar."})
      return (false)
    }
    if (values.passwordRegister!==values.passwordConfirm) { 
      setValues({...values, validationError: "As senhas precisam ser iguais para finalizar o cadastro."})
      return (false)
    }
    // retorno = retorno && (values.passwordRegister===values.passwordConfirm)
    // retorno = retorno && (values.passwordRegister != "")
    // retorno = retorno && (values.passwordConfirm != "")
    return (true)
  }

  // const handleClickShowPassword = () => {
  //   setValues({ ...values, showPassword: !values.showPassword });
  //   setEyeState(!eyeIsClosed)
  // };

  // const handlePasswordChange = (event) => {
  //   setValues({ ...values, password: event.target.value});
  // };

  // const handleRememberBox = (event) => {
  //   setRememberPassword(event.target.checked);
  // };

  const handleUsernameChange = (event) =>{
    setValues({...values, username: event.target.value});
  }

  // const handleEntrar = () => {
  //   console.log(values.password)
  //   console.log(rememberBox)
  //   if (rememberBox == true) { 
  //       localStorage.setItem("senha", values.password);
  //   }    
  //   else {
  //       localStorage.removeItem("senha");
  //   }
    
  //   localStorage.setItem("rememberBox",rememberBox);

  //   const data = {
  //       username: values.userName,
  //       password: values.password
  //   };

  //   // fetch('https://exemplo.com/api/login', {
  //   //         method: 'POST',
  //   //         headers: {
  //   //           'Content-Type': 'application/json'
  //   //         },
  //   //         body: JSON.stringify(data)
  //   //       })
  //   //       .then(response => {
  //   //         if (response.ok) {
  //   //           return response.json();
  //   //         } else {
  //   //           throw new Error('Erro na resposta da API');
  //   //         }
  //   //       })
  //   //       .then(data => {
  //   //         // Faça algo com os dados recebidos (exemplo: redirecionar para uma página interna)
  //   //         console.log('Login bem-sucedido:', data);
  //   //       })
  //   //       .catch(error => {
  //   //         // Trate os erros aqui
  //   //         console.error('Erro ao fazer login:', error);
  //   //       });
  //   //     };
  
  // }


  
  const handleRegisterPassword = (event) => { 
    setValues({ ...values, passwordRegister:event.target.value, validationError:""});
  };

  const handleClickShowRegisterPassword = () => {
    setValues({ ...values, showRegisterPassword: !values.showRegisterPassword });
    setEyeRegister(!eyeIsClosedRegister)
  };


  const handleConfirmPassword = (event) => {
    setValues({ ...values, passwordConfirm:event.target.value, validationError:""});
  };

  const handleClickShowConfirmPassword = () => {
    setValues({ ...values, showConfirmPassword: !values.showConfirmPassword });
    setEyeConfirm(!eyeIsClosedConfirm)
  };

  const handleBtnRegister = async (event) => {
    event.preventDefault()
    if (Validar()){
      const data = {
        username: values.username,
        password: values.passwordRegister
      };
  
      const response = await fetch("http://localhost:8080/systemskills/auth/register",{
          method:"POST",
          headers:{'Content-Type':'application/json'},
          body:JSON.stringify(data)
      });

      if(response.status === 200){
        navigate("/login");
      }
      else{
        setValues({...values, validationError: "Usuario ja existe."})
      }
    }
  }


  return (
    <div className="main">
      <div className="register">
        <form className="form">
          <label htmlFor="chk" aria-hidden="true"
          className="chk">
            Cadastre-se
          </label>
          <br />
          <input
            value={values.userName}
            onChange={handleUsernameChange}
            className="input"
            type="text"
            name="txt"
            placeholder="Nome de Usuário"
            required=""
          />
          <br />
          <input
            onChange={(event) => handleRegisterPassword(event)}
            value={String (values.passwordRegister)}
            type={values.showRegisterPassword ? "text" : "password"}
            className="input"
            name="pswd"
            placeholder="Senha"
            required=""
          />
          <div className="input-group-append">
            <button
              className="btn btn-outline-secondary"
              id="eyeRegister"
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
            value={String(values.passwordConfirm)}
            className="input"
            type={values.showConfirmPassword ? "text" : "password"}
            name="pswd"
            placeholder="Confirme a Senha"
            required=""
          />
          <div className="input-group-append">
            <button
              className="btn btn-outline-secondary"
              id="eyeConfirm"
              onClick={(event) => {event.preventDefault();
              handleClickShowConfirmPassword();
              }}
            >
              {eyeIsClosedConfirm ? <VscEyeClosed /> : <VscEye />}
            </button>
            </div>

          {/* <p
          id="registerError"
          onClick={handleRegisterError}
          >
          Use senhas iguais para o seu cadastro
          </p> */}

          <p>{values.validationError}</p>

          <button
          className="btnCadastrar"
          onClick={handleBtnRegister}
          >Cadastrar</button>
        </form>
      </div>
    </div>
  );
}

export default Cadastro;
