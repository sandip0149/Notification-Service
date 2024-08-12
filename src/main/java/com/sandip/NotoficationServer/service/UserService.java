package com.sandip.NotoficationServer.service;

import com.sandip.NotoficationServer.entity.UserDto;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto userDto);

    List<UserDto> getAllUser();

    void deleteUser(Integer id);

}
