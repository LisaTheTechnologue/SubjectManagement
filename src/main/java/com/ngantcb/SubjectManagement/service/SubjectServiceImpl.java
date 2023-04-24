package com.ngantcb.SubjectManagement.service;

import com.ngantcb.SubjectManagement.model.Subject;
import com.ngantcb.SubjectManagement.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject save(Subject subject) {
        Subject createResponse = subjectRepository.save(subject);
        return createResponse;
    }

    @Override
    public Subject get(Long id) {
        Optional<Subject> response = subjectRepository.findById(id);
        Subject getResponse = response.get();
        return getResponse;
    }

    @Override
    public List<Subject> getByKeyword(String keyword) {
        return subjectRepository.findByKeyword(keyword);
    }

    @Override
    public List<Subject> getAll() {
        List<Subject> response = subjectRepository.findAll();
        return response;
    }

    @Override
    public void delete(Subject subject) {
        subjectRepository.delete(subject);
    }
}
