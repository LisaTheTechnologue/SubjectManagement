package com.ngantcb.SubjectManagement.repo;

import com.ngantcb.SubjectManagement.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Serializable> {
}
