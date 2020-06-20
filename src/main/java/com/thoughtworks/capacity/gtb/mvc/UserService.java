package com.thoughtworks.capacity.gtb.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private Map<String,User> userMap=new HashMap<>();

    private static int id=3;

    public UserService() {
        userMap.put("tomtom",new User("tomtom", "Aa_123456","tom@test.com"));
        userMap.put("jerry",new User("jerry", "Aa_123456","jerry@test.com"));
    }

    public Map<String, User> getAllUsers() {
        return userMap;
    }

    public void login(CreateLoginRequest createLoginRequest) {

        User newUser = createLoginRequest.toUser();

        if(userMap.containsKey(newUser.getUsername())){
            User temp=userMap.get(newUser.getUsername());
            if(!temp.getPassword().equals(newUser.getPassword())){
                throw new UserAccountErrorException("用户名或密码错误");
            }
        }

    }

    public ResponseEntity<Void> register(CreateAccountRequest createAccountRequest) {

        User newUser = createAccountRequest.toUser();

        if(userMap.containsKey(newUser.getUsername())){
            throw new UserHasExistedException("用户已存在");
        }

        userMap.put(newUser.getUsername(),newUser);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}