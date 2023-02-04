package com.main.entities;

import lombok.*;

import javax.persistence.Embeddable;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UniversityPhoneNumbers {
    @Getter
    @Setter
    String authorityName;

    @Getter
    @Setter
    String phone;
}
