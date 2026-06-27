package com.example.loginweb2.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class HomeController {
    @GetMapping("/login")
    public String trangDangnhap(){return "giaodien";}
    @GetMapping("/quenmatkhau")
    public String trangQuanmatkhau(){return  "quenmatkhau";}
    @GetMapping("/dangki")
    public String trangDangki(){return "dangki";}
    @GetMapping("/home")
    public String trangHome(HttpSession session, Model model) {
        Boolean loginn = (Boolean) session.getAttribute("loginn");
        if (loginn == null || !loginn) {
            return "redirect:/login";
        }
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
