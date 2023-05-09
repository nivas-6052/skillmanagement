package com.spring.app.controller;


import com.spring.app.Repository.HRRepository;
import com.spring.app.exception.ResourceNotFoundException;
import com.spring.app.model.HR;
import com.spring.app.service.HRService;
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
public class HRController {
    @Autowired
    private HRRepository hrRepository;
    @Autowired
    private HRService hrService;
    @GetMapping("/hrs")
    public List<HR> getAllHRs(){
        return hrRepository.findAll();
    }

    // create hr rest api
    @PostMapping("/hrs")
    public HR createHR(@RequestBody HR hr) {
        return hrRepository.save(hr);
    }

    // get hr by id rest api
    @GetMapping("/hrs/{id}")
    public ResponseEntity<HR> getHRById(@PathVariable Long id) {
        HR hr = hrRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HR not exist with id :" + id));
        return ResponseEntity.ok(hr);
    }

    // update hr rest api

    @PutMapping("/hrs/{id}")
    public ResponseEntity<HR> updateHR(@PathVariable Long id, @RequestBody HR hrDetails){
        HR hr = hrRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
        hr.setHrId(hrDetails.getHrId());
        hr.setHrName(hrDetails.getHrName());
        hr.setPassword(hrDetails.getPassword());

        HR updatedHR = hrRepository.save(hr);
        return ResponseEntity.ok(updatedHR);
    }

    // delete hr rest api
    @DeleteMapping("/hrs/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteHR(@PathVariable Long id){
        HR hr = hrRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        hrRepository.delete(hr);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



    @GetMapping("/hrs/get")
    public ResponseEntity<List<HR>>getHR() {
        List<HR> hrList = hrService.getAllHRs();
        return new ResponseEntity<>(hrList, HttpStatus.OK);
    }

}
