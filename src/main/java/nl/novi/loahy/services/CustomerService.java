package nl.novi.loahy.services;

import nl.novi.loahy.dtos.CustomerDto;
import nl.novi.loahy.dtos.CustomerInputDto;
import nl.novi.loahy.exceptions.CustomerNotFoundException;
import nl.novi.loahy.models.Customer;
import nl.novi.loahy.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.loahy.dtos.CustomerDto.transferToCustomerDto;


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
            collection.add(transferToCustomerDto(customer));
        }
        return collection;
    }


    public CustomerDto createCustomer(CustomerInputDto inputDto) {

        Customer newCustomer = transferToCustomer(inputDto);

        customerRepository.save(newCustomer);

        return transferToCustomerDto(newCustomer);

    }


    public CustomerDto getCustomer(Long customerId) {
        CustomerDto dto = new CustomerDto();
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            dto = transferToCustomerDto(customer.get());
        } else {
            throw new CustomerNotFoundException(customerId);
        }
        return dto;
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public CustomerDto updateCustomer(Long customerId, CustomerInputDto inputDto) {
        if (customerRepository.findById(customerId).isPresent()) {

            Customer customer = customerRepository.findById(customerId).get();

            Customer customer1 = transferToCustomer(inputDto);
            customer1.setCustomerId(customer.getCustomerId());

            customerRepository.save(customer1);

            return transferToCustomerDto(customer1);
        } else {
            throw new CustomerNotFoundException(customerId);
        }
    }

    public  Customer transferToCustomer(CustomerInputDto productDto) {

        var customer = new Customer();

        customer.setCustomerFirstName(productDto.getCustomerFirstName());
        customer.setCustomerLastName(productDto.getCustomerLastName());
        customer.setCustomerHouseNumber(productDto.getCustomerHouseNumber());
        customer.setCustomerHouseNumberAddition(productDto.getCustomerHouseNumberAddition());
        customer.setCustomerZipcode(productDto.getCustomerZipcode());
        customer.setCustomerCity(productDto.getCustomerCity());
        customer.setCustomerCity(productDto.getCustomerCity());
        customer.setCustomerPhone(productDto.getCustomerPhone());
        return customer;
    }


}


