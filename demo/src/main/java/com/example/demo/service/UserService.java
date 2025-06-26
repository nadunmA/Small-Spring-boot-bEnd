package com.example.demo.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getAllUsers() {

        List<User> UserList = userRepo.findAll();
        return modelMapper.map(UserList, new TypeToken<List<UserDto>>() {
        }.getType());

    }

    public UserDto saveUser(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
        return userDto;
    }

    public UserDto updateUser(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
        return userDto;
    }

    public String deleteUser(Integer userId) {
        userRepo.deleteById(userId);
        return "User deleted";
    }

    public UserDto getUserById(Integer userId) {
        User user = userRepo.getUserById(userId);
        return modelMapper.map(user, UserDto.class);
    }
}
