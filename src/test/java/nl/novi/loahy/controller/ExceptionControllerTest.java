package nl.novi.loahy.controller;

import nl.novi.loahy.controllers.ExceptionController;
import nl.novi.loahy.exceptions.AboutBrandNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ExceptionControllerTest {

    @InjectMocks
    private ExceptionController exceptionController;

    @Test
    @DisplayName(
            "Should return a response entity with the message and status code when the exception is AboutBrandNotFoundException")
    void exceptionWhenAboutBrandNotFoundExceptionThenReturnResponseEntityWithMessageAndStatusCode() {

        String message = "Record not found";
        AboutBrandNotFoundException aboutBrandNotFoundException = new AboutBrandNotFoundException(message);

        ResponseEntity<Object> responseEntity =
                exceptionController.exception(aboutBrandNotFoundException);

        assertEquals(message, responseEntity.getBody());
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

}