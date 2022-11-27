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

    @GetMapping(value = "users")
    public ResponseEntity<List<CustomerDto>> getCustomers() {

        List<CustomerDto> customerDtos = customerService.getCustomers();

        return ResponseEntity.ok().body(customerDtos);
    }

//    @PostMapping(value = "/create")
//    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
//        customerService.saveCustomer(customerDto.toCustomer());
//        return CustomerDto.fromCustomer(customerDto);
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") Long customerId) {

        CustomerDto optionalCustomer = customerService.getCustomer(customerId);

        return ResponseEntity.ok().body(optionalCustomer);
    }

    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable("id") Long customerId,
                                      @RequestBody Customer customer) {
        customerService.updateCustomer(customerId, customer);

        return CustomerDto.fromCustomer(customer);
    }

    @DeleteMapping(value = "{id}")
    public void deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}


