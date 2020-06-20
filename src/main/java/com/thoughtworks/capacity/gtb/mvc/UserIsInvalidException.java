package com.thoughtworks.capacity.gtb.mvc;

public class UserIsInvalidException extends RuntimeException {
    public UserIsInvalidException(String message){
        super(message);
    }
}
