package com.neikiskill.system_skills.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neikiskill.system_skills.models.Usuario;
import com.neikiskill.system_skills.repositories.UsuarioRepository;

@Service
public class LoginService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario) {
        //TODO: FILL IT UP BOY
        return usuarioRepository.save(usuario);

    }

    // @Transactional
    // public String logoutUser() {
    //     UserDetailsImp userDetails = (UserDetailsImp) SecurityContextHolder.getContext()
    //             .getAuthentication()
    //             .getPrincipal();
    //     Integer userId = userDetails.getId();
    //     return "Log out successful!";
    // }

    // @Transactional
    // public SignupResponseDTO authenticateUser(LoginRequestDTO loginRequest) {
    //     Authentication authentication = authenticationManager
    //             .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getCpf(),
    //                     loginRequest.getPassword()));

    //     SecurityContextHolder.getContext().setAuthentication(authentication);

    //     UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();

    //     String jwt = jwtUtils.generateJwtToken(userDetails);

    //     List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
    //             .collect(Collectors.toList());

    //     return new SignupResponseDTO(jwt, userDetails.getId(), userDetails.getCpf(), roles);
    // }
}
