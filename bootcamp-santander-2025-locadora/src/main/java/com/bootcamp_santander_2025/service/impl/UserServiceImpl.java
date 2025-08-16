package com.bootcamp_santander_2025.service.impl;

import com.bootcamp_santander_2025.domain.model.User;
import com.bootcamp_santander_2025.domain.repository.UserRepository;
import com.bootcamp_santander_2025.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User creat(User userToCreat) {
        if (userRepository.existsbyAccountNumber(userToCreat.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreat);
    }

    @Override
    public Object create(User userToCreate) {
        return null;
    }
}
