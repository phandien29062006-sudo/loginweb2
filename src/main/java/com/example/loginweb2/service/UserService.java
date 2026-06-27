package com.example.loginweb2.service;
import com.example.loginweb2.entity.User;
import com.example.loginweb2.responsitory.Responsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    Responsitory responsitory;
    public boolean login(String username, String password){
        User user=responsitory.findByUsername(username);
        if(user==null){
            return false;
        }
        return user.getPassword().equals(password);
    }
    public boolean register(String username, String password){
        User currentUser=responsitory.findByUsername(username);
        if (currentUser != null){
            return false;
        }
        User newUser=new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        responsitory.save(newUser);
        return true;
    }
    public boolean updatepassword(String username, String newpassword){
        User user=responsitory.findByUsername(username);
        if(user==null){
            return false;
        }
        user.setPassword(newpassword);
        responsitory.save(user);
        return true;
    }
}
