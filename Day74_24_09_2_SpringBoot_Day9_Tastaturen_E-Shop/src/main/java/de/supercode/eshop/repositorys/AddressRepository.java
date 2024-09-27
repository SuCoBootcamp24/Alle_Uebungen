package de.supercode.eshop.repositorys;

import de.supercode.eshop.entitys.persons.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Long> {
    Optional<Address> findByStreetAndHouseNumber(String street, String houseNumber);
}
