package com.spring.app.service.impl;


import com.spring.app.Repository.HRRepository;
import com.spring.app.model.HR;
import com.spring.app.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HRServiceImpl implements HRService {
    @Autowired
    private HRRepository hrRepository;
    @Override
    public List<HR> getAllHRs() {
        return hrRepository.findAll();
    }
}
