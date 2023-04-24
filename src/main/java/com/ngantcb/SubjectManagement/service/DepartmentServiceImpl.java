package com.ngantcb.SubjectManagement.service;

import com.ngantcb.SubjectManagement.model.Department;
import com.ngantcb.SubjectManagement.model.Subject;
import com.ngantcb.SubjectManagement.repo.DepartmentRepository;
import com.ngantcb.SubjectManagement.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAll() {
        List<Department> response = departmentRepository.findAll();
        return response;
    }
}
