package com.spring.app.service;

import com.spring.app.model.skillset;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface skillsetService {
    public List<skillset>getAllskills();

    List<skillset> findAllskills();
}
