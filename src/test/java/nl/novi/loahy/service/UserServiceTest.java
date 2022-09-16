package nl.novi.loahy.service;

import nl.novi.loahy.dtos.UserDto;
import nl.novi.loahy.models.User;
import nl.novi.loahy.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    User mockUserEmail;

    @InjectMocks
    UserService sut;

    @Test
    public void whenUserEmailExistsAnExceptionIsThrown(){

        //Arrange
        when(userRepository.findUserByUserEmailIs("ggd_daguiar@gmail.com"))
                .thenReturn(Optional.of(mockUserEmail));

        UserDto userDto = new UserDto();
        userDto.setUserEmail("ggd_daguiar@hotmail.com");

        //Act


        //Assert


    }

}