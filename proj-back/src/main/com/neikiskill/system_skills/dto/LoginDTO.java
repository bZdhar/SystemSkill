package com.neikiskill.system_skills.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String username;
    private String password;

    public String getUsername(){
        return username;
    }
}

