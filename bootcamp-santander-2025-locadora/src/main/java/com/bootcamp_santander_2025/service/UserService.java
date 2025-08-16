package com.bootcamp_santander_2025.service;

import com.bootcamp_santander_2025.domain.model.User;

public interface UserService {

    User findById(Long id);

    User creat(User userToCreat);

    Object create(User userToCreate);
}
