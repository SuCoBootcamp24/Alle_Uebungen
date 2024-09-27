package de.supercode.eshop.repositorys;

import de.supercode.eshop.entitys.persons.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findByFirstnameAndLastname(String firstname, String lastname);
}
