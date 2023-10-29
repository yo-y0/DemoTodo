package com.example.todoServer.exception;

public class Exception extends RuntimeException{

    public Exception(String message) {
        super(message);
    }

    // Your other custom exceptions can be defined here as well

    public static class EmailExistsException extends Exception {

        public EmailExistsException() {
            super("Email is already in use.");
        }

        public EmailExistsException(String message) {
            super(message);
        }
    }
    public static class UserExistsException extends Exception {

        public UserExistsException() {
            super("User doesn't exist");
        }

        public UserExistsException(String message) {
            super(message);
        }
    }

}
