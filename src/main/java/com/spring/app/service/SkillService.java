package com.spring.app.service;

import com.spring.app.model.Skill;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface SkillService {
    List<Skill> getAllSkills();
}
