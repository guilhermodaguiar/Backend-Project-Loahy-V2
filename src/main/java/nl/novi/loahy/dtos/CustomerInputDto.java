package nl.novi.loahy.dtos;


import nl.novi.loahy.models.Customer;

public class CustomerInputDto {

    public Long customerId;
    public String customerFirstName;
    public String customerLastName;
    public String customerStreetName;
    public String customerHouseNumber;
    public String customerHouseNumberAddition;
    public String customerCity;
    public String customerZipcode;
    public Long customerPhone;

    public Customer toCustomer() {

        var customer = new Customer();

        customer.setCustomerId(customerId);
        customer.setCustomerFirstName(customerFirstName);
        customer.setCustomerLastName(customerLastName);
        customer.setCustomerStreetName(customerStreetName);
        customer.setCustomerHouseNumber(customerHouseNumber);
        customer.setCustomerHouseNumberAddition(customerHouseNumberAddition);
        customer.setCustomerCity(customerCity);
        customer.setCustomerZipcode(customerZipcode);
        customer.setCustomerPhone(customerPhone);


        return customer;
    }
}
