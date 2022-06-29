package org.tretton63.demovaadin1363.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class ContactDetails {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
