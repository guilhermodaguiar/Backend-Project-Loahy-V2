package nl.novi.loahy.controllers;


import nl.novi.loahy.dtos.UserDto;
import nl.novi.loahy.exceptions.BadRequestException;
import nl.novi.loahy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserDto> userDtos = userService.getAllUsers();

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{user-email}")
    public ResponseEntity<UserDto> getUserByUserEmail(@PathVariable("user-email") String userEmail) {

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
    public ResponseEntity<UserDto> updateUser(@PathVariable("user_email")String userEmail, @RequestBody UserDto userDto) {

        userService.updateUser(userEmail, userDto);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "delete/{user_email}")
    public ResponseEntity<UserDto>deleteUser(@PathVariable("user_email") String userEmail) {
        userService.deleteUser(userEmail);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{user_email}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("user_email") String costumerEmail) {
        return ResponseEntity.ok().body(userService.getAuthorities(costumerEmail));
    }

    @PostMapping(value = "/{user_email}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("user_email") String userEmail, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(userEmail, authorityName);
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{user_email}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("user_email") String userEmail, @PathVariable("authority") String authority) {
        userService.removeAuthority(userEmail, authority);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userEmail}/{customerId}")
    public void assignCustomerToUser(@PathVariable("userEmail") String userEmail,
                                   @PathVariable("customerId") Long customerId) {

        userService.assignCustomerToUser(customerId, userEmail);

    }
}
