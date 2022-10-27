package nl.novi.loahy.controller;

import nl.novi.loahy.controllers.AuthenticationController;
import nl.novi.loahy.payload.AuthenticationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationController authenticationController;



    @Test
    @DisplayName("Should throw an exception when the user-email or password are incorrect")
    void createAuthenticationTokenWhenUsernameOrPasswordAreIncorrectThenThrowException() {
        AuthenticationRequest authenticationRequest =
                new AuthenticationRequest("user-email", "password");
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new BadCredentialsException("Incorrect user-email or password"));

        Exception exception =
                assertThrows(
                        Exception.class,
                        () -> {
                            authenticationController.createAuthenticationToken(
                                    authenticationRequest);
                        });

        assertEquals("Incorrect user-email or password", exception.getMessage());
    }
}