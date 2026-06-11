package com.example.loginweb2.controller;
import com.example.loginweb2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    UserService service;
    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password){
        if (service.login(username,password)){
            return "Đăng nhập thành công";
        }
        return "Đăng nhập thất bại";
    }
}
