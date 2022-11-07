package nl.novi.loahy.services;


import nl.novi.loahy.dtos.UserDto;
import nl.novi.loahy.exceptions.UserEmailAlreadyExistException;
import nl.novi.loahy.exceptions.UserEmailNotFoundException;
import nl.novi.loahy.models.Authority;
import nl.novi.loahy.models.User;
import nl.novi.loahy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }


    public UserDto getUserByUserEmail(String userEmail) {
        new UserDto();
        UserDto userDto;
        Optional<User> user = userRepository.findById(userEmail);
        if (user.isPresent()) {
            userDto = fromUser(user.get());
        } else {
            throw new UserEmailNotFoundException(userEmail);
        }
        return userDto;
    }

    public boolean userExist(String userEmail) {
        return userRepository.existsById(userEmail);
    }


    public String createUser(UserDto userDto) {
        if (userExist(userDto.getUserEmail())) {
            throw new UserEmailAlreadyExistException(userDto.userEmail);
        }
        User newUser = toUser(userDto);
        newUser.setUserPassword(passwordEncoder.encode(userDto.password));
        userRepository.save(newUser);
        return newUser.getUserEmail();
    }

    public void updateUser(String userEmail, UserDto newUser) {
        if (!userRepository.existsById(userEmail)) throw new UserEmailNotFoundException(userEmail);
        User user = userRepository.findById(userEmail).get();
        user.setUserPassword(passwordEncoder.encode(newUser.password));
        user.setUserEmail(newUser.getUserEmail());
        userRepository.save(user);
    }

    public void deleteUser(String userEmail) {
        userRepository.deleteById(userEmail);
    }


    public Set<Authority> getAuthorities(String userEmail) {
        if (!userRepository.existsById(userEmail)) throw new UserEmailNotFoundException(userEmail);
        User user = userRepository.findById(userEmail).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
    }

    public void addAuthority(String userEmail, String authority) {

        if (!userRepository.existsById(userEmail)) throw new UserEmailNotFoundException(userEmail);
        User user = userRepository.findById(userEmail).get();
        user.addAuthority(new Authority(userEmail, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String userEmail, String authority) {
        if (!userRepository.existsById(userEmail)) throw new UserEmailNotFoundException(userEmail);
        User user = userRepository.findById(userEmail).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

    public static UserDto fromUser(User user){

        var userDto = new UserDto();

        userDto.userEmail = user.getUserEmail();
        userDto.password = user.getUserPassword();
        userDto.authorities = user.getAuthorities();

        return userDto;
    }

    public User toUser(UserDto userDto) {

        var user = new User();

        user.setUserPassword(userDto.getUserPassword());
        user.setUserEmail(userDto.getUserEmail());

        return user;
    }

    public UserDto transferToDto(User user){

        var userDto = new UserDto();

        userDto.userEmail = user.getUserEmail();
        userDto.password = user.getUserPassword();

        return userDto;
    }


}
