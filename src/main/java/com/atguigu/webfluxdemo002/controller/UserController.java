package com.atguigu.webfluxdemo002.controller;

import com.atguigu.webfluxdemo002.entity.User;
import com.atguigu.webfluxdemo002.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Mono<User> getUserId(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping("/user")
    public Flux<User> getUser(){
        return userService.getAllUser();
    }

    @PostMapping("/saveuser")
    public Mono<Void> saveUser(@RequestBody User user){
       Mono<User> userMono = Mono.just(user);
       return userService.saveUserInfo(userMono);
    }




}
