package com.neikiskill.system_skills.dto;

import lombok.Data;

@Data
public class UsuarioRequestDTO {
    private String username;
    private String token;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
