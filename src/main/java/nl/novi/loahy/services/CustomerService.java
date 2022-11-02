package nl.novi.loahy.services;

import nl.novi.loahy.dtos.CustomerDto;
import nl.novi.loahy.exceptions.CustomerNotFoundException;
import nl.novi.loahy.models.Customer;
import nl.novi.loahy.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> getCustomers() {
        List<CustomerDto> collection = new ArrayList<>();
        List<Customer> list = customerRepository.findAll();
        for (Customer customer : list) {
            collection.add(CustomerDto.fromCustomer(customer));
        }
        return collection;
    }


    public CustomerDto getCustomer(Long customerId) {
        CustomerDto dto = new CustomerDto();
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            dto = CustomerDto.fromCustomer(customer.get());
        } else {
            throw new CustomerNotFoundException(customerId);
        }
        return dto;
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }


    public void updateCustomer(Long customerId, Customer customer) {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException(customerId);
        } else {

            Customer customer1 = optionalCustomer.get();
            customer1.setCustomerId(customer.getCustomerId());
            customer1.setCustomerFirstName(customer.getCustomerFirstName());
            customer1.setCustomerLastName(customer.getCustomerLastName());
            customer1.setCustomerStreetName(customer.getCustomerStreetName());
            customer1.setCustomerHouseNumber(customer.getCustomerHouseNumber());
            customer1.setCustomerHouseNumberAddition(customer.getCustomerHouseNumberAddition());
            customer1.setCustomerCity(customer.getCustomerCity());
            customer1.setCustomerZipcode(customer.getCustomerZipcode());
            customer1.setCustomerPhone(customer.getCustomerPhone());

            customerRepository.save(customer1);
        }
    }
}


