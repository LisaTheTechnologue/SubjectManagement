package com.ngantcb.SubjectManagement.controller;

import com.ngantcb.SubjectManagement.model.Department;
import com.ngantcb.SubjectManagement.model.Subject;
import com.ngantcb.SubjectManagement.service.DepartmentService;
import com.ngantcb.SubjectManagement.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService service;
    @Autowired
    private DepartmentService dService;

    @GetMapping("/")
    public String index(Model model, String keyword, String department) {
        List<Department> departments = dService.getAll();
        model.addAttribute("options", departments);

        model.addAttribute("subjects", service.getAll());
        return "index";
    }
    @GetMapping("/search")
    public String findByKeyword(Model model, @RequestParam("keyword") String keyword) {
        List<Department> departments = dService.getAll();
        model.addAttribute("options", departments);
        if (keyword != null) {
            model.addAttribute("subjects", service.getByKeyword(keyword));
        } else model.addAttribute("subjects", service.getAll());
        return "index";
    }
    @GetMapping("/filter")
    public String findByDepartment(Model model, @RequestParam("department") Long departmentId) {
        List<Department> departments = dService.getAll();
        model.addAttribute("options", departments);
        if (departmentId != null) {
            model.addAttribute("subjects", service.getByDepartmentId(departmentId));
        } else model.addAttribute("subjects", service.getAll());
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
    public String addSubject(@Valid Subject subject,
                             Model model) {
        try {
            Subject subjectDb = service.save(subject);
            // check if subject code existed in database
            if (subjectDb==null) {
                model.addAttribute("error", "existed");
                List<Department> departments = dService.getAll();
                model.addAttribute("options", departments);
                model.addAttribute("subject", new Subject());
                return "create";
            }
        } catch (Exception ex) {
            // if subject cannot be saved
            model.addAttribute("error", "failed");
            List<Department> departments = dService.getAll();
            model.addAttribute("options", departments);
            model.addAttribute("subject", new Subject());
            return "create";
        }
        return "redirect:/";
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
