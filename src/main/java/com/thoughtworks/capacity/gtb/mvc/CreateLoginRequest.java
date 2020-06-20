package com.thoughtworks.capacity.gtb.mvc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CreateLoginRequest {

    @NotBlank
    @Size(min = 5,max = 12, message = "用户不合法")
    private String username;

    @Pattern(regexp = "^[0-9a-zA-Z_]+$", message = "用户不合法")
    @Pattern(regexp = ".*[a-z].*", message = "用户不合法")
    @Pattern(regexp = ".*[A-Z].*", message = "用户不合法")
    @Pattern(regexp = ".*[_].*", message = "用户不合法")
    @Size(min = 5,max = 12, message = "用户不合法")
    private String password;


    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CreateLoginRequest(
                              @JsonProperty("username") String username,
                              @JsonProperty("password") String password
    ) {
        this.username = username;
        this.password = password;
    }

    public User toUser() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        return user;
    }
}
