package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class Usercontroller {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public List<UserDto> getUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        // TODO: process POST request

        return userService.saveUser(userDto);
    }

    @PutMapping("/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        // TODO: process POST request

        return userService.updateUser(userDto);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody UserDto userDto) {
        // TODO: process POST request

        return userService.deleteUser(userDto);
    }
}
