package nl.novi.loahy.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "customers")
public class Customer {


    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_customer", value = "product_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "5004"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    Long customerId;
    @Column(name = "customer_first_name")
    String customerFirstName;
    @Column(name = "customer_last_name")
    String customerLastName;
    @Column(name = "customer_street_name")
    String customerStreetName;
    @Column(name = "customer_house_number")
    String customerHouseNumber;
    @Column(name = "customer_add_number")
    String customerHouseNumberAddition;
    @Column(name = "customer_city")
    String customerCity;
    @Column(name = "customer_zipcode")
    String customerZipcode;
    @Column(name = "customer_phone")
    Long customerPhone;


    @OneToOne(mappedBy = "customer")
    User user;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerStreetName() {
        return customerStreetName;
    }

    public void setCustomerStreetName(String customerStreetName) {
        this.customerStreetName = customerStreetName;
    }

    public String getCustomerHouseNumber() {
        return customerHouseNumber;
    }

    public void setCustomerHouseNumber(String customerHouseNumber) {
        this.customerHouseNumber = customerHouseNumber;
    }

    public String getCustomerHouseNumberAddition() {
        return customerHouseNumberAddition;
    }

    public void setCustomerHouseNumberAddition(String customerHouseNumberAdd) {
        this.customerHouseNumberAddition = customerHouseNumberAdd;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerZipcode() {
        return customerZipcode;
    }

    public void setCustomerZipcode(String customerZipcode) {
        this.customerZipcode = customerZipcode;
    }

    public Long getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Long customerPhone) {
        this.customerPhone = customerPhone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
