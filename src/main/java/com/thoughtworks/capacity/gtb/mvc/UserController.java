package com.thoughtworks.capacity.gtb.mvc;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@ResponseBody
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody CreateAccountRequest createAccountRequest) {
         userService.register(createAccountRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/login")
    public void login(@Valid @RequestBody CreateLoginRequest createLoginRequest) {
         userService.login(createLoginRequest);
    }

    @GetMapping(value = "/get")
    public Map<String, User> getAllUsers() {
        return userService.getAllUsers();
    }
}