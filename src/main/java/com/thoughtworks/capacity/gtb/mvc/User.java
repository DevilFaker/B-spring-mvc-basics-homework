package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class User {
    private static int id=0;

    private String username;
    private String password;
    private String emailAddress;

    public User(String username, String password, String emailAddress) {
        this.id=id++;
        this.username=username;
        this.password=password;
        this.emailAddress=emailAddress;
    }


}
