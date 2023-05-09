package com.spring.app.service;

import com.spring.app.model.HR;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HRService {
    public List<HR> getAllHRs();
}
