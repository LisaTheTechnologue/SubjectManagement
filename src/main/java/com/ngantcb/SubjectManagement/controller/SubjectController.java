package com.ngantcb.SubjectManagement.controller;

import com.ngantcb.SubjectManagement.model.Subject;
import com.ngantcb.SubjectManagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/create")
    public Subject createStudent1(@RequestBody Subject subject) {
        Subject createResponse = subjectService.save(subject);
        return createResponse;
    }

    @GetMapping("/{id}")
    public Subject getStudent(@PathVariable Long id) {
        Subject getReponse = subjectService.get(id);
        return getReponse;
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody Subject subject) {
        subjectService.delete(subject);
        return "Record deleted succesfully";
    }
}
