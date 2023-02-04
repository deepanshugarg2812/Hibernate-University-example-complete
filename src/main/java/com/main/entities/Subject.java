package com.main.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    @ManyToMany(targetEntity = Teacher.class,mappedBy = "subjectList")
    @Setter
    @Getter
    List<Teacher> teacherList;
}
