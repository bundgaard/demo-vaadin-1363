package org.tretton63.demovaadin1363.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String agreementId;

    @Embedded
    private SparDetails sparDetails;
    @Embedded
    private ContactDetails contactDetails;
}
