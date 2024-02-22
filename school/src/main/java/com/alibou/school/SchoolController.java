package com.alibou.school;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    @Autowired
    SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody School school
    ) {
        service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(service.findAllSchools());
    }

//    @GetMapping("/with-students/{school-id}")
//    public ResponseEntity<FullSchoolResponse> findAllSchools(
//            @PathVariable("school-id") Integer schoolId
//    ) {
//        return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
//    }
}
