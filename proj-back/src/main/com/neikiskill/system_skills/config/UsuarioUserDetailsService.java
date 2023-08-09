package com.neikiskill.system_skills.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neikiskill.system_skills.models.Usuario;
import com.neikiskill.system_skills.repositories.UsuarioRepository;

@Service
public class UsuarioUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Username not found");
        }
        
        return new User(usuario.getUsername(), usuario.getPassword(), new ArrayList<GrantedAuthority>());
    }
}
