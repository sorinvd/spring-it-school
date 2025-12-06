package com.itschool.springapp.controller;

import com.itschool.springapp.model.UserDTO;
import com.itschool.springapp.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService UserServiceAttribute;


    public UserController(UserService userServiceParam) {
        this.UserServiceAttribute = userServiceParam;
    }

    @GetMapping("{providedID}")
    public UserDTO getUser(@PathVariable long providedID) {

        return UserServiceAttribute.getUSer(providedID);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO param) {

        return UserServiceAttribute.createUser(param);
    }
}
