package com.sample.caffeinespringboot.service;


import com.sample.caffeinespringboot.persistence.entity.User;
import com.sample.caffeinespringboot.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserAdapter {

    private final UserRepository userRepository;

    public UserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findById(Long id) {
        User user = null;

        log.info("In adapter for findById with id: {}", id);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        return user;
    }

    public List<User> findAll() {
        List<User> userList = null;

        log.info("In adapter for findAll");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<User> userListRepository = userRepository.findAll();

        if (!userListRepository.isEmpty()) {
            userList = userListRepository;
        }

        return userList;
    }
}
