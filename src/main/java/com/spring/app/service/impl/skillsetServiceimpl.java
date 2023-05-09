package com.spring.app.service.impl;

import com.spring.app.Repository.SkillsetRepository;
import com.spring.app.model.skillset;
import com.spring.app.service.skillsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class skillsetServiceimpl implements skillsetService {
    @Autowired
    private SkillsetRepository skillsetRepository;
    @Override
    public List<skillset> getAllskills() {
        return skillsetRepository.findAll();
    }

    @Override
    public List<skillset> findAllskills() {
        return skillsetRepository.findAll();
    }
}
