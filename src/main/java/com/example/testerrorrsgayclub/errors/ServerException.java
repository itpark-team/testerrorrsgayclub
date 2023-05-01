package com.example.testerrorrsgayclub.errors;


public class ServerException extends CustomException {

    public ServerException(String title, String message, int code) {
        super(title, message, code);
    }
}
