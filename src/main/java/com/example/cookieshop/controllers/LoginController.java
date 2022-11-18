package com.example.cookieshop.controllers;

import com.example.cookieshop.models.Person;
import com.example.cookieshop.repositories.LoginRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    LoginRepository repo = new LoginRepository();

    @PostMapping ("/login")
    public String login(HttpSession session, WebRequest req){

        Person person = new Person(req.getParameter("user"), req.getParameter("pass"));
        int userId = repo.loggedin(person);

        if(userId == -1){
            return "redirect:/";
        }
        session.setAttribute("log", userId);
        return "redirect:/shop";

    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        System.out.println(session.getAttribute("log"));
        session.invalidate();
        return "redirect:/";
    }




}
