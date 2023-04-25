package com.ngantcb.SubjectManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @Column(name = "SUBJECT_CODE",unique=true)
    @NotNull(message = "Subject code cannot be null")
    private String subjectCode;

    @Column(name = "SUBJECT_NAME_VI")
    @NotNull(message = "Subject name (Vietnamese) cannot be null")
    private String subjectNameVi;

    @Column(name = "SUBJECT_NAME_EN")
    @NotNull(message = "Subject name (English) cannot be null")
    private String subjectNameEn;

    @ManyToOne
    @JoinColumn(name="DEPARTMENT_ID", nullable=false)
    @NotNull(message = "Department cannot be null")
    private Department department;

    @Column(name = "CAMPUS")
    private String campus="Campus 1";

    @Column(name = "GRADE")
    @Min(value = 0, message = "Grade must be number > 0")
    private String grade;

    @Column(name = "TERM")
    @Min(value = 0, message = "Term must be number > 0")
    private String term;

    @Column(name = "SHORT_NAME")
    @NotEmpty(message = "Short name must be not null")
    private String shortName;

    @Column(name = "IS_EXTRA", columnDefinition = "TINYINT", length = 1)
    private Boolean isExtra;

}
