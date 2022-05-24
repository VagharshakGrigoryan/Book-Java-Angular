package com.example.bookbackend.service;

import com.example.bookbackend.dtos.UserDto;
import com.example.bookbackend.entity.User;
import com.example.bookbackend.exception.ResourceNotFoundException;
import com.example.bookbackend.mapper.UserMapper;
import com.example.bookbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> getAll() {
        List<User> projections = this.userRepository.findAll();

        if(projections.isEmpty()){
            throw new ResourceNotFoundException("users");
        }
        return this.userMapper.usersToDto(projections);
    }

    public Page<UserDto> getAll(Pageable pageable) {
        Page<User> projections = this.userRepository.findAll(pageable);

        if(projections.isEmpty()){
            throw new ResourceNotFoundException("users");
        }
        return projections.map(this.userMapper::userToDto);
    }

    public UserDto getById(Long id){
        return this.userRepository.findById(id)
                .map(this.userMapper::userToDto)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
    }


    public void deleteById(Long id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
        this.userRepository.delete(user);
    }

    public UserDto update(UserDto userDto){
        User userToUpdate = this.userRepository.findById(userDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", userDto.getId()));

        userToUpdate.setFirstName(userDto.getFirstName());
        userToUpdate.setLastName(userDto.getLastName());
        userToUpdate.setEmail(userDto.getEmail());
        userToUpdate.setRole(userDto.getRole());

        return this.userMapper.userToDto(this.userRepository.save(userToUpdate));
    }
}
