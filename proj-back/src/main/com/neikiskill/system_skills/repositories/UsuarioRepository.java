package com.neikiskill.system_skills.repositories;

import com.neikiskill.system_skills.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    @Query(value = "select * from usuario where username=:username", nativeQuery = true)
    public Usuario findByUsername(String username);

}
