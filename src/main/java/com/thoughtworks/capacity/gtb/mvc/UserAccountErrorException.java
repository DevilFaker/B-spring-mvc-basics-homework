package com.thoughtworks.capacity.gtb.mvc;

public class UserAccountErrorException extends RuntimeException {
    public UserAccountErrorException(String message){
        super(message);
    }
}
