package com.main.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "University")
@NoArgsConstructor
@AllArgsConstructor
public class University {
    @Id
    @SequenceGenerator(name = "university_seq",initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "university_name",nullable = false,unique = true)
    @Getter
    @Setter
    String univName;

    @ElementCollection
    List<UniversityPhoneNumbers> universityPhoneNumbersList;

    //one university has many departments in it and one->many
    @OneToMany(targetEntity = Department.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "univ_id")
    @Setter
    @Getter
    List<Department> departmentsList;

    public University(String univName, List<UniversityPhoneNumbers> universityPhoneNumbersList) {
        this.univName = univName;
        this.universityPhoneNumbersList = universityPhoneNumbersList;
    }

    public University(String univName, List<UniversityPhoneNumbers> universityPhoneNumbersList, List<Department> departmentsList) {
        this.univName = univName;
        this.universityPhoneNumbersList = universityPhoneNumbersList;
        this.departmentsList = departmentsList;
    }
}
