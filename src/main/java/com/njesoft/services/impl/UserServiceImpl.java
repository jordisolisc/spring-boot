package com.njesoft.services.impl;

import com.njesoft.model.User;
import com.njesoft.repository.UserRepository;
import com.njesoft.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findOne(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "{'message': 'User deleted successfully.'}";

    }
}
