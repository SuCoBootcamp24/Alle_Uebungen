package de.supercode.eshop.services;

import de.supercode.eshop.dtos.CustomerDTO;
import de.supercode.eshop.entitys.orders.ShoppingBasket;
import de.supercode.eshop.entitys.persons.Address;
import de.supercode.eshop.entitys.persons.Customer;
import de.supercode.eshop.mappers.CustomerMapper;
import de.supercode.eshop.repositorys.AddressRepository;
import de.supercode.eshop.repositorys.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    AddressRepository addressRepository;
    CustomerMapper customerMapper;


    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.customerMapper = customerMapper;
    }

    public Optional<Customer> findCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public boolean deleteCustomer(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            customerRepository.delete(customerOptional.get());
            return true;
        }
        return false;
    }


    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        if (customerRepository.findByFirstnameAndLastname(customerDTO.getFirstname(), customerDTO.getLastname()).isPresent()) return null;
        Customer newCustomer = extractCustomer(customerDTO);
        if (customerDTO.getStreet() != null) {
            Address newAddress = extractAddress(customerDTO);
            newCustomer.setAddress(newAddress);
        }
        customerRepository.save(newCustomer);
        return customerMapper.toDTO(newCustomer);
    }

    private Customer extractCustomer(CustomerDTO customerDTO) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstname(customerDTO.getFirstname());
        newCustomer.setLastname(customerDTO.getLastname());
        newCustomer.setEmail(customerDTO.getEmail());
        newCustomer.setBirthDate(customerDTO.getBirthDate());
        return newCustomer;
    }

    private Address extractAddress(CustomerDTO customerDTO) {
        Address newAddress = new Address();
        newAddress.setStreet(customerDTO.getStreet());
        newAddress.setHouseNumber(customerDTO.getHouseNumber());
        newAddress.setCity(customerDTO.getCity());
        newAddress.setZipCode(customerDTO.getZipCode());
        newAddress.setCountry(customerDTO.getCountry());
        return newAddress;
    }


    public CustomerDTO getCustomer(Long id) {
        Optional<Customer> existCustomer = customerRepository.findById(id);
        return existCustomer.map(customer -> customerMapper.toDTO(customer)).orElse(null);
    }


    public CustomerDTO upgradeCustomer(Long customerID, CustomerDTO customerDTO) {
        Optional<Customer> existCustomer = customerRepository.findById(customerID);
        if (existCustomer.isEmpty()) return null;

        updateCustomerDetails(existCustomer.get(), customerDTO);
        updateCustomerAddress(existCustomer.get(), customerDTO);

        customerRepository.save(existCustomer.get());

        return customerMapper.toDTO(existCustomer.get());
    }

    private void updateCustomerDetails(Customer customer, CustomerDTO customerDTO) {
        Optional.ofNullable(customerDTO.getFirstname()).ifPresent(customer::setFirstname);
        Optional.ofNullable(customerDTO.getLastname()).ifPresent(customer::setLastname);
        Optional.ofNullable(customerDTO.getEmail()).ifPresent(customer::setEmail);
        Optional.ofNullable(customerDTO.getBirthDate()).ifPresent(customer::setBirthDate);
    }

    private void updateCustomerAddress(Customer customer, CustomerDTO customerDTO) {
        Address address = customer.getAddress();

        if (address == null) {
            address = new Address();
            customer.setAddress(address);
        }

        boolean isUpdated = updateAddressFields(address, customerDTO);
        if (isUpdated) {
            addressRepository.save(address);
        }
    }

    private boolean updateAddressFields(Address address, CustomerDTO customerDTO) {
        boolean isUpdated = false;

        if (customerDTO.getStreet() != null && !customerDTO.getStreet().equals(address.getStreet())) {
            address.setStreet(customerDTO.getStreet());
            isUpdated = true;
        }
        if (customerDTO.getCity() != null && !customerDTO.getCity().equals(address.getCity())) {
            address.setCity(customerDTO.getCity());
            isUpdated = true;
        }
        if (customerDTO.getZipCode() != null && !customerDTO.getZipCode().equals(address.getZipCode())) {
            address.setZipCode(customerDTO.getZipCode());
            isUpdated = true;
        }
        if (customerDTO.getCountry() != null && !customerDTO.getCountry().equals(address.getCountry())) {
            address.setCountry(customerDTO.getCountry());
            isUpdated = true;
        }

        return isUpdated;
    }

    public void upgradeCustomerBasket(Customer customer, ShoppingBasket shoppingBasket) {
        customer.setShoppingBasket(shoppingBasket);
        customerRepository.save(customer);
    }

    public void deleteBasket(Customer customer) {
        customer.setShoppingBasket(null);
        customerRepository.save(customer);
    }
}
