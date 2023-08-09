package com.neikiskill.system_skills.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neikiskill.system_skills.models.UsuarioSkill;
import com.neikiskill.system_skills.models.UsuarioSkillId;
import com.neikiskill.system_skills.repositories.UsuarioSkillRepository;

@Service
public class UsuarioSkillService{
    
    @Autowired
    private UsuarioSkillRepository usuarioSkillRepository;
    
    public UsuarioSkill getUsuarioSkillById(UsuarioSkillId usuarioSkillId){
        return usuarioSkillRepository.findById(usuarioSkillId).orElse(null);
    }

    public void addUsuarioSkill(UsuarioSkill usuarioSkill){
        usuarioSkillRepository.save(usuarioSkill);
    }

    public void addUsuarioSkill(int usuarioId, int skillId, int nivelId){
        usuarioSkillRepository.adicionarUsuarioSkillPorIds(usuarioId, skillId, nivelId);
    }
}
