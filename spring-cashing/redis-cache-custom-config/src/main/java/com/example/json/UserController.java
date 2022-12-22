package com.example.json;

import com.example.json.model.UserRedis;
import com.example.json.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRedis createUser(@RequestBody UserRedis user) {
        return this.service.save(user);
    }

    @GetMapping("/fetch/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserRedis retrieveUser(@PathVariable Long id) {
        return this.service.getById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserRedis> retrieveUsers() {
        return this.service.findAllUser();
    }
//
//    @DeleteMapping("delete/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteOneUser(@PathVariable("id") int userId) {
//        this.service.deleteOneUser(userId);
//    }
}