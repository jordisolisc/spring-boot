package com.njesoft.controller;

import com.njesoft.model.User;
import com.njesoft.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> userList() {
        return userService.userList();
    }

    @RequestMapping("/list/{id}")
    public Optional<User> findById(@PathVariable Integer id) {
        return userService.findById(id);
    }
    @RequestMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }
}
