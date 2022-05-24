package com.example.bookbackend.mapper;

import com.example.bookbackend.dtos.UserDto;
import com.example.bookbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto userToDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getRole()

        );
    }

    public List<UserDto> usersToDto(List<User> users){
        return users.stream().map(this::userToDto).collect(Collectors.toList());
    }
}
