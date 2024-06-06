package com.sample.caffeinespringboot.rest.controller;

import com.sample.caffeinespringboot.persistence.entity.User;
import com.sample.caffeinespringboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id)  {
        return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers()  {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
}
