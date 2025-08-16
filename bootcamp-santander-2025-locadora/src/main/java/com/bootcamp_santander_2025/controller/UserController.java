package com.bootcamp_santander_2025.controller;


import com.bootcamp_santander_2025.domain.model.User;
import com.bootcamp_santander_2025.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userServise;

    public UserController(UserService userServise) {
        this.userServise = userServise;
    }

    @GetMapping("./{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userServise.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> creat(@RequestBody User userToCreate) {
        var userCreated = userServise.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getClass()).toUri();
        return ResponseEntity.created(location).body(userToCreate);
    }

}
