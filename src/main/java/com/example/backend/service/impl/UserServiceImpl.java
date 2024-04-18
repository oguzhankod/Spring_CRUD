package com.example.backend.service.impl;

import com.example.backend.entities.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> newUser= userRepository.findById(id);
        if (newUser.isPresent()){
            newUser.get().setFirstName(user.getFirstName());
            newUser.get().setLastName(user.getLastName());
            return userRepository.save(newUser.get());
        }

        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> deleteUser = userRepository.findById(id);
        if (deleteUser.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
