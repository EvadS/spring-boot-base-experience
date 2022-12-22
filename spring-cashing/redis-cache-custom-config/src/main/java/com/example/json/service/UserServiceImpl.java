package com.example.json.service;


import com.example.json.model.UserRedis;
import com.example.json.repo.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements  UserService{
    private final UserRepository userRepository;

    @Override
    @Cacheable(value = "user", key = "#userRedis.getId()")
    public UserRedis getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserRedis save(UserRedis user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserRedis> findAllUser() {
        return userRepository.findAll();
    }
}
