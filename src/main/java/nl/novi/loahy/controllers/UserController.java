package nl.novi.loahy.controllers;

import nl.novi.loahy.dtos.CustomerDto;
import nl.novi.loahy.dtos.CustomerInputDto;
import nl.novi.loahy.dtos.UserDto;
import nl.novi.loahy.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {


    private final UserService userService;

    private final CustomerController customerController;


    public UserController(UserService userService, CustomerController customerController) {
        this.userService = userService;
        this.customerController = customerController;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserDto> userDtos = userService.getAllUsers();

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{user_email}")
    public ResponseEntity<UserDto> getUserByUserEmail(@PathVariable("user_email") String userEmail) {

        UserDto optionalUser = userService.getUserByUserEmail(userEmail);

        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        String newUserEmail = userService.createUser(userDto);
        userService.addAuthority(newUserEmail, "ROLE_USER");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{user-email}/")
                .buildAndExpand(newUserEmail).toUri();

        return ResponseEntity
                .created(location)
                .build();
    }

    @PutMapping(value = "/{user_email}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("user_email") String userEmail, @RequestBody UserDto userDto) {

        userService.updateUser(userEmail, userDto);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete/{user_email}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("user_email") String userEmail) {
        userService.deleteUser(userEmail);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{user_email}/{customerId}")
    public void assignCustomerToUser(@PathVariable("user_email") String userEmail,
                                   @PathVariable("customerId") Long customerId) {

        userService.assignCustomerToUser(customerId, userEmail);

    }

    @PostMapping("/{user_email}/customer")
    public void registerCustomerToUser(@PathVariable("user_email") String userEmail,
                                     @RequestBody CustomerInputDto inputDto) {

        CustomerInputDto customerData = customerController.createCustomer(inputDto);


        userService.registerCustomerToUser(customerData.getCustomerId(), userEmail);
    }
}
