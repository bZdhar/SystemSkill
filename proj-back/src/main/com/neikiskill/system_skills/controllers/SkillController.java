package com.neikiskill.system_skills.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neikiskill.system_skills.models.Skill;
import com.neikiskill.system_skills.services.SkillService;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "*")
public class SkillController {

    @Autowired
    SkillService skillService;
    
    @CrossOrigin
    @GetMapping({"","/"})
    public ResponseEntity<List<Skill>> getAll(){
        return new ResponseEntity<List<Skill>>(skillService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable("id") int id){
        return new ResponseEntity<Skill>(skillService.getSkillById(id), HttpStatus.OK);
    }
}
