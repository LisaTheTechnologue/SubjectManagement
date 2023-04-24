package com.ngantcb.SubjectManagement.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_subject")
@Data
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SUBJECT_CODE")
    private String subjectCode;

    @Column(name = "SUBJECT_NAME_VI")
    private String subjectNameVi;

    @Column(name = "SUBJECT_NAME_EN")
    private String subjectNameEn;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "CAMPUS")
    private String campus;

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "TERM")
    private String term;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @Column(name = "IS_EXTRA")
    private String isExtra;
}
