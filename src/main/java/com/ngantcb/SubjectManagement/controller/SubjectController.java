package com.ngantcb.SubjectManagement.controller;

import com.ngantcb.SubjectManagement.model.Department;
import com.ngantcb.SubjectManagement.model.Subject;
import com.ngantcb.SubjectManagement.service.DepartmentService;
import com.ngantcb.SubjectManagement.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService service;
    @Autowired
    private DepartmentService dService;

    @GetMapping(value = {"/", "/index", "/home"})
    public String index(Model model, String keyword) {
        List<Department> departments = dService.getAll();
        model.addAttribute("options", departments);

        List<Subject> subjects = service.getAll();
        if (keyword != null) {
            model.addAttribute("subjects", service.getByKeyword(keyword));
        } else model.addAttribute("subjects", subjects);
        return "index";
    }

    @GetMapping("/create")
    public String createSubject(Model model) {
        // form
        List<Department> departments = dService.getAll();
        model.addAttribute("options", departments);
        model.addAttribute("subject", new Subject());
        return "create";
    }

    @PostMapping("/create")
    public String addSubject(@ModelAttribute("subject") @Valid Subject subject,
                             Model model) {

        try {
            service.save(subject);
        } catch (Exception ex) {
            model.addAttribute("error", "failed");
            List<Department> departments = dService.getAll();
            model.addAttribute("options", departments);
            model.addAttribute("subject", new Subject());
            return "create";
        }
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public Subject getStudent(@PathVariable Long id) {
        Subject getReponse = service.get(id);
        return getReponse;
    }

    @GetMapping("/delete/{id}")
    public String deleteSubject(@PathVariable(value = "id") Long id, Model model) {
        try {
            service.delete(id);
        } catch (Exception ex) {
            model.addAttribute("error", "failed");
            model.addAttribute("employees", service.getAll());
            return "index";
        }
        return "redirect:/";
    }
}
