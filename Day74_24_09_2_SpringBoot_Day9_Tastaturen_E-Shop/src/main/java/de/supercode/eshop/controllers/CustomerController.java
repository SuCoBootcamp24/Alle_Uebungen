package de.supercode.eshop.controllers;

import de.supercode.eshop.dtos.CustomerDTO;
import de.supercode.eshop.services.CustomerService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/eshop/customer")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO newCustomer = customerService.createCustomer(customerDTO);

        if (newCustomer == null) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO existCustomer = customerService.getCustomer(id);

        if (existCustomer == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(existCustomer);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO updateCustomerDTO) {
        CustomerDTO updatedCustomer = customerService.upgradeCustomer(id, updateCustomerDTO);

        if (updatedCustomer == null) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,String> handleValidationError(ConstraintViolationException ex){
        Map<String,String> errorMap = new HashMap<>();
        ex.getConstraintViolations()
                .forEach(violation-> {
                    String fieldName = violation.getPropertyPath().toString();
                    String errorMessage = violation.getMessage();
                    errorMap.put(fieldName,errorMessage);
                });
        return errorMap;
    }

}
