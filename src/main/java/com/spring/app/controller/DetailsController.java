package com.spring.app.controller;

import com.spring.app.Repository.DetailsRepository;

import com.spring.app.exception.ResourceNotFoundException;
import com.spring.app.model.Details;
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
public class DetailsController {



        @Autowired
        private DetailsRepository detailsRepository;

    @GetMapping("/data")
    public List<Details> getAllDetailss(){
//        List<Details> mydata=detailsRepository.findAll();
//        return ResponseEntity.ok(mydata);
        return detailsRepository.findAll();
    }

        // create employee rest api
        @PostMapping("/data")
        public Details createDetails(@RequestBody Details employee) {
            return detailsRepository.save(employee);
        }

        // get employee by id rest api
        @GetMapping("/data/{id}")
        public ResponseEntity<Details> getDetailsById(@PathVariable Long id) {
            Details employee = detailsRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Details not exist with id :" + id));
            return ResponseEntity.ok(employee);
        }

        // update employee rest api

        @PutMapping("/data/{id}")
        public ResponseEntity<Details> updateDetails(@PathVariable Long id, @RequestBody Details employeeDetails) {
            Details employee = detailsRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
            employee.setEmpId(employeeDetails.getEmpId());
            employee.setEmpName(employeeDetails.getEmpName());
            employee.setSkillObj(employeeDetails.getSkillObj());

            Details updatedDetails = detailsRepository.save(employee);
            return ResponseEntity.ok(updatedDetails);
        }

        // delete employee rest api
        @DeleteMapping("/data/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteDetails(@PathVariable Long id) {
            Details employee = detailsRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

            detailsRepository.delete(employee);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }

//        @GetMapping("/data/get")
//        public ResponseEntity<List<Details>> getDetails() {
//            List<Details> employeeList = detailsRepository.getAllDetailss();
//            return new ResponseEntity<>(employeeList, HttpStatus.OK);
//        }
//
//        @GetMapping("/data")
//        public List<Details> getAllDetailss() {
//            return employeeService.findAll();
//        }
//
    }