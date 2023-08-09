package com.neikiskill.system_skills.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neikiskill.system_skills.models.Nivel;
import com.neikiskill.system_skills.repositories.NivelRepository;

@Service
public class NivelService {

    @Autowired
    private NivelRepository nivelRepository;

    public Nivel getNivelById(int nivelId) {
        return nivelRepository.findById(nivelId).orElse(null);
    }

    public List<Nivel> getAll(){
        return nivelRepository.findAll();
    }
}
