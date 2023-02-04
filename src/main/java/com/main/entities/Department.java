package com.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Department")
@SequenceGenerator(name = "department_seq",initialValue = 2)
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long dept_id;

    @Getter
    @Setter
    @Column(name = "Department_name",nullable = false)
    String name;

    //one teacher can belong to many departments and one department can have many teachers
    @ManyToMany(targetEntity = Teacher.class)
    @JoinTable(name = "dept_teacher",joinColumns = {@JoinColumn(name = "dept_id")},inverseJoinColumns = {@JoinColumn(name = "teacher_id")})
    @Setter
    @Getter
    List<Teacher> teacherList;

    //one department can have one phone number
    @ManyToOne(targetEntity = Phone.class)
    Phone phone;
}
