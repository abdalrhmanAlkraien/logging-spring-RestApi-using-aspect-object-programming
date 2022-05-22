package com.logging.aspect.loggingspringrestapiusingaspectobjectprogramming.service;

import com.logging.aspect.loggingspringrestapiusingaspectobjectprogramming.controller.UserController;
import com.logging.aspect.loggingspringrestapiusingaspectobjectprogramming.model.UserDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserController userController;

    public UserService(UserController userController){
        this.userController=userController;
    }

    public UserDto login(UserDto userDto) throws Exception {
        if(userDto.getUserName().equals("abualrhman")){
            throw new Exception();
        }
        return userDto;
    }
}
