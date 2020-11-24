package com.njesoft.services;

import com.njesoft.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> userList();

    Optional<User> findById(Integer id);

    User addUser(User user);

    String deleteUser(Integer id);
}
