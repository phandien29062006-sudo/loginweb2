package com.example.loginweb2.responsitory;
import com.example.loginweb2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface Responsitory extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}
