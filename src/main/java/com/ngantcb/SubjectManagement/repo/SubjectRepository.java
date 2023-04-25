package com.ngantcb.SubjectManagement.repo;

import com.ngantcb.SubjectManagement.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Serializable> {

    @Query(value = "SELECT * FROM TBL_SUBJECT S " +
            "WHERE S.SUBJECT_CODE LIKE %:keyword% " +
            "OR S.SUBJECT_NAME_VI LIKE %:keyword% " +
            "OR S.SUBJECT_NAME_EN LIKE %:keyword% ", nativeQuery = true)
    List<Subject> findByKeyword(@Param("keyword") String keyword);

    List<Subject> findByDepartmentId(Long departmentId);

    @Query(value = "SELECT * FROM TBL_SUBJECT S " +
            "WHERE S.SUBJECT_CODE = :subjectCode " +
            "LIMIT 1", nativeQuery = true)
    Subject checkIfSubjectCodeExists(@Param("subjectCode") String subjectCode);
}
