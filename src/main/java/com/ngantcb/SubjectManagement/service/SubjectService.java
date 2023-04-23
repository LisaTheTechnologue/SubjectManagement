package com.ngantcb.SubjectManagement.service;

import com.ngantcb.SubjectManagement.model.Subject;

import java.util.List;

public interface SubjectService {
    public Subject save(Subject student);
    public Subject get(Long id);
    public List<Subject> getAll();
    public void delete(Subject student);
}
