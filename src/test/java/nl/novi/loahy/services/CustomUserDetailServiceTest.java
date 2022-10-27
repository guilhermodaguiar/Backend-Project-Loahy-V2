package nl.novi.loahy.services;

import nl.novi.loahy.dtos.UserDto;
import nl.novi.loahy.models.Authority;
import nl.novi.loahy.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    @Test
    @DisplayName("Should throw UserEmailNotFoundException when user is not found")
    void loadUserByUserEmailWhenUserIsNotFoundThenThrowUserEmailNotFoundException() {
        when(userService.getUserByUserEmail(anyString()))
                .thenReturn();

        assertThrows(
                UsernameNotFoundException.class,
                () -> customUserDetailsService.loadUserByUsername("user-email"));
    }

    @Test
    @DisplayName("Should return UserDetails when user is found")
    void loadUserByUsernameWhenUserIsFoundThenReturnUserDetails() {
        User user = new User();
        user.setUserEmail("test");
        user.setUserPassword("test");
        user.addAuthority(new Authority("test", "ROLE_USER"));

        when(userService.getUserByUserEmail(anyString()))
                .thenReturn(List.of(user));

        UserDetails userDetails = customUserDetailsService.loadUserByUsername("test");

        assertEquals("test", userDetails.getUsername());
        assertEquals("test", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));
    }
}