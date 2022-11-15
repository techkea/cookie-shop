package com.example.cookieshop.controllers;

import com.example.cookieshop.models.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CookController {



        @GetMapping("/session")
        public String sessionExample(HttpSession session, Model model){
            Cookie cookieObject = new Cookie(1,"MagicX",150);
            session.setAttribute("cookie", cookieObject);
            model.addAttribute("cookies", cookieObject);
            return "index";
        }

        @GetMapping("/getDataFromSession")
        public String getDataFromSession(HttpSession session){
            Cookie magicCookie = (Cookie) session.getAttribute("cookie");
            if(magicCookie.getName().equals("Magic") ){
                System.out.println("You are logged in");
            }
            else {
                System.out.println("No no no");
                session.invalidate();
                return "redirect://logedout";
            }
            System.out.println(magicCookie);
            return "index";
        }



}
