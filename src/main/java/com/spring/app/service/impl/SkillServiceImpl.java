package com.spring.app.service.impl;

import com.spring.app.Repository.SkillRepository;
import com.spring.app.model.Skill;
import com.spring.app.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;
    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
}
