package nl.novi.loahy.exceptions;

 public class UserEmailNotFoundException extends RuntimeException {
     private static final long serialVersionUID = 1L;


     public UserEmailNotFoundException(String userEmail) {

         super(String.format("User with email-adres'%s' does not exists", userEmail));
     }

 }
