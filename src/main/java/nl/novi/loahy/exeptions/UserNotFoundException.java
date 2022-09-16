package nl.novi.loahy.exeptions;

 public class UserNotFoundException extends RuntimeException {
     private static final long serialVersionUID = 1L;


     public UserNotFoundException(String userEmail) {

         super(String.format("User with email-adres'%s' does not exists", userEmail));
     }

 }
