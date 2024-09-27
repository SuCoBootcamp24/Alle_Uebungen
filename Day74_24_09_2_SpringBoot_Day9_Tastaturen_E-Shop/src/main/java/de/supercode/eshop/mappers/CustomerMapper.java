package de.supercode.eshop.mappers;

import de.supercode.eshop.dtos.CustomerDTO;
import de.supercode.eshop.entitys.persons.Address;
import de.supercode.eshop.entitys.persons.Customer;
import de.supercode.eshop.services.AddressService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerMapper {

    AddressService addressService;

    public CustomerMapper(AddressService addressService) {
        this.addressService = addressService;
    }



    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setFirstname(customer.getFirstname());
        dto.setLastname(customer.getLastname());
        dto.setEmail(customer.getEmail());
        dto.setBirthDate(customer.getBirthDate());

        if (customer.getAddress() != null) {
            dto.setStreet(customer.getAddress().getStreet());
            dto.setHouseNumber(customer.getAddress().getHouseNumber());
            dto.setCity(customer.getAddress().getCity());
            dto.setZipCode(customer.getAddress().getZipCode());
            dto.setCountry(customer.getAddress().getCountry());
        }
        return dto;
    }


    public Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstname(customerDTO.getFirstname());
        customer.setLastname(customerDTO.getLastname());
        customer.setEmail(customerDTO.getEmail());

        if (customerDTO.getStreet()!= null) {
            Optional<Address> existAddress = addressService.findAddressByStreetAndHouseNumber(customerDTO.getStreet(), customerDTO.getHouseNumber());
            if (existAddress.isPresent()) customer.setAddress(existAddress.get());
            else {
                Address newAddress = new Address();
                newAddress.setStreet(customerDTO.getStreet());
                newAddress.setHouseNumber(customerDTO.getHouseNumber());
                newAddress.setCity(customerDTO.getCity());
                newAddress.setZipCode(customerDTO.getZipCode());
                newAddress.setCountry(customerDTO.getCountry());
                customer.setAddress(newAddress);
            }
        }
        return customer;
    }
}
