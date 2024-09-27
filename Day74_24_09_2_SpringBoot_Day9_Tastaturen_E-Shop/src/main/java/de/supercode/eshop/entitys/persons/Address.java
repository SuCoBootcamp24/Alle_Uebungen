package de.supercode.eshop.entitys.persons;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String street;

    private String houseNumber;

    @NotBlank
    private String city;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String country;

    @OneToOne(mappedBy = "address")
    @EqualsAndHashCode.Exclude
    private Customer customer;


}
