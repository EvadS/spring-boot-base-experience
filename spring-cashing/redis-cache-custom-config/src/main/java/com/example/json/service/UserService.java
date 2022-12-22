package com.example.json.service;

import com.example.json.model.UserRedis;

import java.util.Collection;
import java.util.List;

public interface UserService {
    UserRedis getById(Long id);

    UserRedis save(UserRedis user);

    List<UserRedis> findAllUser();
}
