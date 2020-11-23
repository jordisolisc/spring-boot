package com.njesoft.controller;

import com.njesoft.model.User;
import com.njesoft.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public List<User> userList() {
        return userService.userList();
    }

    @RequestMapping("/list/{id}")
    public Optional<User> findOne(@PathVariable Integer id) {
        return userService.findOne(id);
    }

    @RequestMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }
}
