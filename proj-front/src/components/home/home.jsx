import React, { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import { VscEye, VscEyeClosed } from "react-icons/vsc";
import "./home.css";
import { InputGroup } from "react-bootstrap";
import SkillModal from "./skillModal";

function Home() {
  const navigate = useNavigate();
  const [values, setValues] = useState({
    token: localStorage.getItem('token'),
    usuario: '',
    skills: ''
  });

  const handleLogout = (event) => {
    event.preventDefault();
    
    localStorage.removeItem("token");
    navigate('/login');
  }

  return (
    <div id="main"> {/* main */}
      <div id="chamadah1"> {/* chamada da pagina */}
        bem vindo usuario
      </div>
      <div id="chamadah2"> {/*  chamada para a lista de skills*/}
        selecione sua skill
        <div className="listaSkill"> {/* lista de skills */}
          lista de skills
          <div className="editSkill"> {/* edição das skills*/}
            edição da lista
          </div>
        </div>
      </div>

      <div id="btnSave"> {/* btnSalvar*/}
        <button className="btn">
        salvar
        </button>
      </div>
      <div id="btnCancel">{/* btnCancelar */}
        <button className="btn">
          cancelar
        </button>
      </div>
      <div id="btnExit"> {/* logout */}
        <button className="btn" onClick={handleLogout}>
        sair
        </button>
      </div>
      <SkillModal></SkillModal>

    </div>
  );
}

export default Home;