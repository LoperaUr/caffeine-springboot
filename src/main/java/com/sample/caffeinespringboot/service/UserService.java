package com.sample.caffeinespringboot.service;

import com.sample.caffeinespringboot.config.CacheConfig;
import com.sample.caffeinespringboot.exception.GenericException;
import com.sample.caffeinespringboot.persistence.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserAdapter userAdapter;

    public UserService(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    @Cacheable(value = CacheConfig.USERS_INFO_CACHE)
    public User get(Long id) {

        User user = userAdapter.findById(id);
        if (user == null) throw new GenericException("user not found");

        return user;
    }

    @Cacheable(value = CacheConfig.USERS_INFO_CACHE)
    public List<User> getAll() {
        List<User> userList = userAdapter.findAll();
        if (userList == null) throw new GenericException("no users");
        return userList;
    }
}
