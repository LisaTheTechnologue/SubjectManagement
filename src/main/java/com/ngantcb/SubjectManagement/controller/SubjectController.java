package com.ngantcb.SubjectManagement.controller;

import com.ngantcb.SubjectManagement.model.Subject;
import com.ngantcb.SubjectManagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping(value = {"/", "/index", "/home"})
    public String index(Model model) {
        model.addAttribute("subjects", service.getAll());
        return "index";
    }

    @PostMapping("/create")
    public Subject createStudent(@RequestBody Subject subject) {
        Subject createResponse = service.save(subject);
        return createResponse;
    }

    @GetMapping("/{id}")
    public Subject getStudent(@PathVariable Long id) {
        Subject getReponse = service.get(id);
        return getReponse;
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody Subject subject) {
        service.delete(subject);
        return "Record deleted succesfully";
    }
}
