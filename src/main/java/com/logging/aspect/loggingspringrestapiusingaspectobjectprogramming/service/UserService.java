package com.logging.aspect.loggingspringrestapiusingaspectobjectprogramming.service;

import com.logging.aspect.loggingspringrestapiusingaspectobjectprogramming.model.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDto login(UserDto userDto) throws Exception {
        if(userDto.getUserName().equals(userDto.getPassword())){
            throw new Exception();
        }
        return userDto;
    }
}
