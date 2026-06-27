package com.example.loginweb2.controller;
import com.example.loginweb2.responsitory.Responsitory;
import com.example.loginweb2.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    UserService service;
    @PostMapping("/auth/login")
    public ResponseEntity<String> login(
            @RequestParam String username,                  //request body
            @RequestParam String password,                  //request body
            HttpSession session) {
        if (service.login(username, password)) {
            session.setAttribute("username", username);
            session.setAttribute("loginn", true);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("/home"))
                    .build();
        }
        return ResponseEntity.status(HttpStatus.FOUND)        //status line
                .location(URI.create("/login?error=true"))    //response header
                .build();            // ko có body            //response body
    }
    @PostMapping("/users")
    public ResponseEntity<String> dangki(
            @RequestParam String username,
            @RequestParam String password) {
        if (service.register(username, password)) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("/login"))
                    .build();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Tên tài khoản đã tồn tại");
    }
    @PutMapping("/users/password")
    public ResponseEntity<String> quenmatkhau(
            @RequestParam String username,
            @RequestParam String newpassword){
        if(service.updatepassword(username, newpassword)) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("/login"))
                    .build();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Sai tên tài khoản");
    }


}
