package com.example.json.repo;


import com.example.json.model.UserRedis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRedis, Long> {
}