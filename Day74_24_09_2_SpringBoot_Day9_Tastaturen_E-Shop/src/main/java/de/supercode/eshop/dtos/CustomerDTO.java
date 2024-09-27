package de.supercode.eshop.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDTO {

    private long id;

    @NotEmpty(message = "Firstname cannot be empty")
    private String firstname;

    @NotEmpty(message = "Lastname cannot be empty")
    private String lastname;

    @Email(message = "Email should be valid")
    private String email;

    private LocalDate birthDate;

    private String street;
    private String houseNumber;
    private String city;
    private String zipCode;
    private String country;
}
