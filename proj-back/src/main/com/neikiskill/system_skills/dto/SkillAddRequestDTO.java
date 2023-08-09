package com.neikiskill.system_skills.dto;

import lombok.Data;

@Data
public class SkillAddRequestDTO {
    private int skillId;
    private int usuarioId;
    private int nivelId;
}
