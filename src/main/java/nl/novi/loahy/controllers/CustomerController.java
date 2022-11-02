package nl.novi.loahy.controllers;

import nl.novi.loahy.dtos.CustomerDto;
import nl.novi.loahy.models.Customer;
import nl.novi.loahy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<CustomerDto>> getUsers() {

        List<CustomerDto> userDtos = customerService.getCustomers();

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<CustomerDto> getUser(@PathVariable("username") Long customerId) {

        CustomerDto optionalUser = customerService.getCustomer(customerId);

        return ResponseEntity.ok().body(optionalUser);
    }

    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable Long customerId,
                                  @RequestBody Customer customer) {
        customerService.updateCustomer(customerId, customer);

        return CustomerDto.fromCustomer(customer);
    }

    @DeleteMapping(value = "{id}")
    public void deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}


