package com.main.entities;

import javax.persistence.*;

@Entity
@Table(name = "Phone")
@SequenceGenerator(name = "phone_seq",initialValue = 2)
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "Phone_number")
    String number;

    @OneToOne(targetEntity = Department.class)
    Department department;
}
