package com.example.testerrorrsgayclub.errors;

public class UserException extends CustomException {

    public UserException(String title, String message, int code) {
        super(title, message, code);
    }
}
