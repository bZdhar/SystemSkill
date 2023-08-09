package com.neikiskill.system_skills.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neikiskill.system_skills.models.Usuario;
import com.neikiskill.system_skills.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioByID(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario getUsuarioByUsername(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        return usuario;
    }
}
