package com.logging.aspect.loggingspringrestapiusingaspectobjectprogramming.controller;

import com.logging.aspect.loggingspringrestapiusingaspectobjectprogramming.model.UserDto;
import com.logging.aspect.loggingspringrestapiusingaspectobjectprogramming.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok().body(userService.login(userDto));
    }
}
