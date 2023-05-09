package com.spring.app.controller;

import com.spring.app.Repository.SkillsetRepository;
import com.spring.app.exception.ResourceNotFoundException;
import com.spring.app.model.skillset;
import com.spring.app.service.skillsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;





@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class skillsetcontroller{
    @Autowired
    //private skillsetRepository employeeRepository;
    private SkillsetRepository skillsetRepository;
    @Autowired
    //private skillsetService employeeService;
    private skillsetService skillsetservice;
//    @GetMapping("/skillset")
//    public List<skillset> getAllskillsets(){
//        return employeeRepository.findAll();
//    }

    // create employee rest api
    @PostMapping("/skillset")
    public skillset createskillset(@RequestBody skillset employee) {
        return skillsetRepository.save(employee);
    }

    // get employee by id rest api
    @GetMapping("/skillset/{id}")
    public ResponseEntity<skillset> getskillsetById(@PathVariable Long id) {
        skillset employee = skillsetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("skillset not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }

    // update employee rest api

    @PutMapping("/skillset/{id}")
    public ResponseEntity<skillset> updateskillset(@PathVariable Long id, @RequestBody skillset employeeDetails){
        skillset employee = skillsetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
        employee.setSkillId(employeeDetails.getSkillId());
        employee.setSkillname(employeeDetails.getSkillname());
        employee.setCop(employeeDetails.getCop());
        employee.setSubcop(employeeDetails.getSubcop());
        employee.setVersion(employeeDetails.getVersion());
        employee.setIsdepricted(employeeDetails.getIsdepricted());


        skillset updatedskillset = skillsetRepository.save(employee);
        return ResponseEntity.ok(updatedskillset);
    }

    // delete employee rest api
    @DeleteMapping("/skillset/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteskillset(@PathVariable Long id){
        skillset employee = skillsetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        skillsetRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
//    @GetMapping("/skillset/get")
//    public ResponseEntity<List<skillset>>getskillset() {
//        List<skillset> employeeList = employeeService.getAllskillsets();
//        return new ResponseEntity<>(employeeList, HttpStatus.OK);
//    }
    @GetMapping("/skillset")
    public List<skillset> getAllskillsets(){
        return skillsetservice.findAllskills();
    }


}

