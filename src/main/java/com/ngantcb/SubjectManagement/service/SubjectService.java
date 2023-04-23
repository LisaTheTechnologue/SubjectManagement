package com.ngantcb.SubjectManagement.service;

import com.ngantcb.SubjectManagement.model.Subject;

public interface SubjectService {
    public Subject save(Subject student);
    public Subject get(Long id);
    public void delete(Subject student);
}
