package nl.novi.loahy.controllers;

import nl.novi.loahy.dtos.CustomerDto;
import nl.novi.loahy.dtos.CustomerInputDto;
import nl.novi.loahy.models.Customer;
import nl.novi.loahy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/users")
    @Transactional
    public List<CustomerDto> getCustomerList(@RequestParam(value = "firstname", required = false, defaultValue = "")String customerFirstname,
                                               @RequestParam(value = "lastname", required = false, defaultValue = "")String customerLastname){

        var customerDtos = new ArrayList<CustomerDto>();

        List<Customer> customerList;

        if (customerFirstname == null && customerLastname == null) {
            customerList = CustomerService.getCustomerList();

        } else if (customerFirstname != null && customerLastname == null) {
            customerList = CustomerService.findCustomerListByCustomerFirstname(customerFirstname);

        }else {
            customerList = CustomerService.findCustomerListByCustomerLastname(customerLastname);
        }

        for (Customer customer : customerList) {
            customerDtos.add(customerDtos.fromCustomer(customer));
        }
        return customerDtos;
    }

    @GetMapping("/{id}")
    public customerDto getPerson(@PathVariable("id")Long id) {

        var customer = customerService.getCustomer(id);

        return CustomerDto.fromCustomer(customer);

    }

    @PostMapping
    public CustomerDto savePerson(@RequestBody CustomerInputDto dto) {

        var customer = customerService.saveCustomer(dto.toCustomer());

        return CustomerDto.fromCustomer(customer);
    }

    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable Long id,
                                  @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);

        return CustomerDto.fromCustomer(customer);
    }


    @DeleteMapping(path = "{id}")
    public void deletePerson(
            @PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
