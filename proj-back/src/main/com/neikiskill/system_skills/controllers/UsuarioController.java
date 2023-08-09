package com.neikiskill.system_skills.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neikiskill.system_skills.config.JwtTokenProvider;
import com.neikiskill.system_skills.dto.SkillAddRequestDTO;
import com.neikiskill.system_skills.dto.UsuarioRequestDTO;
import com.neikiskill.system_skills.models.Nivel;
import com.neikiskill.system_skills.models.Skill;
import com.neikiskill.system_skills.models.Usuario;
import com.neikiskill.system_skills.models.UsuarioSkill;
import com.neikiskill.system_skills.models.UsuarioSkillId;
import com.neikiskill.system_skills.services.NivelService;
import com.neikiskill.system_skills.services.SkillService;
import com.neikiskill.system_skills.services.UsuarioService;
import com.neikiskill.system_skills.services.UsuarioSkillService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private NivelService nivelService;
    @Autowired
    private UsuarioSkillService usuarioSkillService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @GetMapping(value = { "", "/" })
    public ResponseEntity<Usuario> getUsuario(@RequestBody UsuarioRequestDTO usernameRequestDTO) {
        if (usernameRequestDTO.getUsername().isEmpty() || usernameRequestDTO.getToken().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        String username = tokenProvider.getUsernameFromJwt(usernameRequestDTO.getToken());

        if (!username.equals(usernameRequestDTO.getUsername())) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = usuarioService.getUsuarioByUsername(username);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PostMapping(value = { "addskill" })
    public ResponseEntity<Boolean> addSkill(@RequestBody SkillAddRequestDTO skillAddRequestDTO) {
        if (skillAddRequestDTO.getNivelId() <= 0 || skillAddRequestDTO.getSkillId() <= 0
                || skillAddRequestDTO.getUsuarioId() <= 0) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = usuarioService.getUsuarioByID(skillAddRequestDTO.getUsuarioId());
        Skill skill = skillService.getSkillById(skillAddRequestDTO.getSkillId());
        Nivel nivel = nivelService.getNivelById(skillAddRequestDTO.getNivelId());

        usuarioSkillService.addUsuarioSkill(usuario.getUsuarioId(), skill.getSkillId(), nivel.getNivelId());
        
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
