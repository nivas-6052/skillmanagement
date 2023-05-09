package com.spring.app.controller;


import com.spring.app.Repository.SkillGapRepository;
import com.spring.app.exception.ResourceNotFoundException;
import com.spring.app.model.SkillGap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SkillGapController {
    @Autowired
    private SkillGapRepository skillgapRepository;

    @GetMapping("/skillgap")
    public List<SkillGap> getAllSkillGaps(){
        return skillgapRepository.findAll();
    }

    // create skillg rest api
    @PostMapping("/skillgap")
    public SkillGap createSkillGap(@RequestBody SkillGap skillg) {
        return skillgapRepository.save(skillg);
    }

    // get skillg by id rest api
    @GetMapping("/skillgap/{id}")
    public ResponseEntity<SkillGap> getSkillGapById(@PathVariable Long id) {
        SkillGap skillg = skillgapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SkillGap not exist with id :" + id));
        return ResponseEntity.ok(skillg);
    }

    // update skillg rest api

    @PutMapping("/skillgap/{id}")
    public ResponseEntity<SkillGap> updateSkillGap(@PathVariable Long id, @RequestBody SkillGap skillg) {
        SkillGap skillgap = skillgapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
        skillgap.setEmpId(skillg.getEmpId());
        skillgap.setEmpName(skillg.getEmpName());
        skillgap.setSkillName(skillg.getSkillName());
        skillgap.setRating(skillg.getRating());

        SkillGap updatedSkillGap = skillgapRepository.save(skillgap);
        return ResponseEntity.ok(updatedSkillGap);
    }

    // delete skillg rest api
    @DeleteMapping("/skillgap/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSkillGap(@PathVariable Long id) {
        SkillGap skillg = skillgapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        skillgapRepository.delete(skillg);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
