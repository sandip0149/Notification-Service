package com.sandip.NotoficationServer.service.impl;

import com.sandip.NotoficationServer.entity.User;
import com.sandip.NotoficationServer.entity.UserDto;
import com.sandip.NotoficationServer.repository.UserRepository;
import com.sandip.NotoficationServer.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto addUser(UserDto userDto) {
        // Convert DTO to Entity
        User user = modelMapper.map(userDto, User.class);

        // Save entity to the database
        User savedUser = userRepository.save(user);

        // Convert entity back to DTO
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        // Retrieve all users from the database
        List<User> users = userRepository.findAll();

        // Convert List of Entities to List of DTOs
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer id) {
        // Delete the user by id
        userRepository.deleteById(id);
    }
}
