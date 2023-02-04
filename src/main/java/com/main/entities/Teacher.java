package com.main.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Can we connected to one or more departments
 */

@Entity
@Table(name = "Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "teacher_name",nullable = false)
    String name;

    //one teacher can belong to many departments and one department can have many teachers
    @ManyToMany(targetEntity = Department.class,mappedBy = "teacherList")
    @Setter
    @Getter
    List<Department> departmentList;

    //one teacher can teach many subjects and one subject can have many teacher
    @ManyToMany(targetEntity = Subject.class)
    @JoinTable(name = "teacher_subject",joinColumns = {@JoinColumn(name = "teacher_id")},inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    @Setter
    @Getter
    List<Subject> subjectList;
}
