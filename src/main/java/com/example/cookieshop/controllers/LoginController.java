package com.example.cookieshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(HttpSession session){
        // SELECT * from users where name = ?
        // if user == claus{
            session.setAttribute("user", "Claus");
        return "login";
         }


    @GetMapping("/secrets")
    public String verySecretSide(HttpSession session){
        var ses = session.getAttribute("user");
        if(ses.equals("Claus")){
            return "secrets";
        }

        return "redirect:/";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
