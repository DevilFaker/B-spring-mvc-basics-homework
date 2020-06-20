package com.thoughtworks.capacity.gtb.mvc;

public class UserHasExistedException extends RuntimeException {
    public UserHasExistedException(String message){
        super(message);
    }
}
