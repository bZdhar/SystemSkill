package com.neikiskill.system_skills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neikiskill.system_skills.models.UsuarioSkill;
import com.neikiskill.system_skills.models.UsuarioSkillId;

import jakarta.transaction.Transactional;

public interface UsuarioSkillRepository extends JpaRepository<UsuarioSkill, UsuarioSkillId> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuario_skill (usuario_id, skill_id, nivel_id) VALUES (:usuario_id, :skill_id, :nivel_id)", nativeQuery = true)
    public int adicionarUsuarioSkillPorIds(@Param("usuario_id") int usuarioId, @Param("skill_id") int skillId,
            @Param("nivel_id") int nivelId);
}
