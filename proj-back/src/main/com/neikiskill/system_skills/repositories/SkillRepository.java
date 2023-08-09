package com.neikiskill.system_skills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neikiskill.system_skills.models.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
        
}