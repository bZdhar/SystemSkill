package com.neikiskill.system_skills.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neikiskill.system_skills.config.JwtTokenProvider;
import com.neikiskill.system_skills.dto.AuthResponseDTO;
import com.neikiskill.system_skills.dto.LoginDTO;
import com.neikiskill.system_skills.dto.RegistroDTO;
import com.neikiskill.system_skills.models.Usuario;
import com.neikiskill.system_skills.repositories.UsuarioRepository;
import com.neikiskill.system_skills.services.LoginService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @CrossOrigin
    @PostMapping("register")
    public ResponseEntity<String> registrar(@RequestBody RegistroDTO registroDTO) {

        if (usuarioRepository.findByUsername(registroDTO.getUsername()) != null) {
            return new ResponseEntity<String>("Usuario ja existe!", HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(registroDTO.getUsername());
        usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));

        usuarioRepository.save(usuario);

        return new ResponseEntity<String>("Usuario registrado", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.generateToken(authentication);

        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }
}
