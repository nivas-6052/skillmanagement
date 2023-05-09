package com.spring.app.controller;

import com.spring.app.Repository.SkillRepository;
import com.spring.app.exception.ResourceNotFoundException;
import com.spring.app.model.Skill;
import com.spring.app.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private SkillService skillService;
    @GetMapping("/skills")
    public List<Skill> getAllSkills(){
        return skillRepository.findAll();
    }

    // create skill rest api
    @PostMapping("/skills")
    public Skill createSkill(@RequestBody Skill skill) {
        return skillRepository.save(skill);
    }

    // get skill by id rest api
    @GetMapping("/skills/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not exist with id :" + id));
        return ResponseEntity.ok(skill);
    }

    // update skill rest api

    @PutMapping("/skills/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skillDetails){
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        skill.setEmpId(skillDetails.getEmpId());
        skill.setSkillId(skillDetails.getSkillId());

        skill.setRating(skillDetails.getRating());
        skill.setExperience(skillDetails.getExperience());
        skill.setRecentlyUsed(skillDetails.getRecentlyUsed());

        Skill updatedSkill = skillRepository.save(skill);
        return ResponseEntity.ok(updatedSkill);
    }

    // delete skill rest api
    @DeleteMapping("/skills/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSkill(@PathVariable Long id){
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        skillRepository.delete(skill);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



    @GetMapping("/skills/get")
    public ResponseEntity<List<Skill>>getSkill() {
        List<Skill> skillList = skillService.getAllSkills();
        return new ResponseEntity<>(skillList, HttpStatus.OK);
    }
}
