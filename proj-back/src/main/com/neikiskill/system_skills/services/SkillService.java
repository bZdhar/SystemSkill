package com.neikiskill.system_skills.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neikiskill.system_skills.models.Skill;
import com.neikiskill.system_skills.repositories.SkillRepository;

@Service
public class SkillService {
    
    @Autowired
    private SkillRepository skillRepository;

    public Skill getSkillById(int id){
        return skillRepository.findById(id).orElse(null);
    }

    public List<Skill> getAll() {
        return skillRepository.findAll();
    }
}
