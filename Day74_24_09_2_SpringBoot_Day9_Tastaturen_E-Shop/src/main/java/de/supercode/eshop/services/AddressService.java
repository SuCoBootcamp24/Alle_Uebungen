package de.supercode.eshop.services;

import de.supercode.eshop.entitys.persons.Address;
import de.supercode.eshop.repositorys.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }



    public Optional<Address> findAddressByStreetAndHouseNumber(String street, String houseNumber) {
        return addressRepository.findByStreetAndHouseNumber(street, houseNumber);
    }
}
