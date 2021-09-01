package com.getir.exception;

public class MailAlreadyExistException extends RuntimeException{

    public MailAlreadyExistException() {
        super();
    }

    public MailAlreadyExistException(String message) {
        super("Mail already exist. Mail: " + message);
    }
}
