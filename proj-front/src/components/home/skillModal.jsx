import React, { useState, useEffect } from "react";
import { Dropdown } from "react-bootstrap";

function SkillModal() {
  const [skillSelecionada, setSkillSelicionada] = useState("Skills");
  const [listaSkills, setListSkills] = useState({});

  useEffect(() => {
    pegarList();
  }, []);

  const pegarList = async () => {
    const response = await fetch("http://localhost:8080/systemskills/skills/", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authentication: "Bearer " + localStorage.getItem("token"),
      },
    });

    setListSkills(await response.json());
  };

  const handleSkillClick = (event) =>{
    console.log(event.target.id);
  }

  const criarListaDeSkills = () => {
    const divListaSkill = [];

    for (let i = 0; i < listaSkills.length; i++) {
      divListaSkill.push(<Dropdown.Item onClick={handleSkillClick} id={listaSkills[i].skillId}>{listaSkills[i].nameSkill}</Dropdown.Item>);
    }
    return divListaSkill;
  };

  return (
    <Dropdown>
      <Dropdown.Toggle variant="success" id="dropdown-basic">
        {skillSelecionada}
      </Dropdown.Toggle>
      <Dropdown.Menu>{criarListaDeSkills()}</Dropdown.Menu>
    </Dropdown>
  );
}

export default SkillModal;
