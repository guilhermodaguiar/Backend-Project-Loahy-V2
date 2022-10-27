package nl.novi.loahy.services;

import nl.novi.loahy.models.Customer;
import nl.novi.loahy.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getCustomerList() {
        return null;
    };
    public List<Customer> findCustomerListByCustomerFirstname(String customerFirstname) {
        return null;
    };
    public List<Customer> findCustomerListByCustomerLastname(String customerLastname) {
        return null;
    };

    Person getCustomer(Long customerId);

    Person saveCustomer(Person person);

    void updateCustomer(Long id, Costomer costomer);

    void deleteCustomer(Long customerId);
}
