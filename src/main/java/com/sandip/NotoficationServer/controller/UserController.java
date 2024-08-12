package com.sandip.NotoficationServer.controller;

import com.sandip.NotoficationServer.entity.UserDto;
import com.sandip.NotoficationServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getall(){
       return userService.getAllUser();
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "Deleted Sucessfully";
    }
}
