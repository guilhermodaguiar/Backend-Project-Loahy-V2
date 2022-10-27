package nl.novi.loahy.dtos;
import nl.novi.loahy.models.Customer;

public class CustomerDto {

    public Long customerId;
    public String customerFirstName;
    public String customerLastName;
    public String customerStreetName;
    public String customerHouseNumber;
    public String customerHouseNumberAddition;
    public String customerCity;
    public String customerZipcode;
    public String customerPhone;


    public static CustomerDto fromCustomer(Customer customer) {
        if (customer == null) return null;

        var customerDto = new CustomerDto();

        customerDto.customerId = customer.getCustomerId();
        customerDto.customerFirstName = customer.getCustomerFirstName();
        customerDto.customerLastName = customer.getCustomerLastName();
        customerDto.customerStreetName = customer.getCustomerStreetName();
        customerDto.customerHouseNumber = customer.getCustomerHouseNumber();
        customerDto.customerHouseNumberAddition = customer.getCustomerHouseNumberAddition();
        customerDto.customerCity = customer.getCustomerCity();
        customerDto.customerZipcode = customer.getCustomerZipcode();
        customerDto.customerPhone = customer.getCustomerPhone();



        return customerDto;
    }
}
