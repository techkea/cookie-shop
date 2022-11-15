package com.example.cookieshop.controllers;

import com.example.cookieshop.models.Cookie;
import com.example.cookieshop.repositories.CookieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CookieController {
    private CookieRepository repo = new CookieRepository();
    private List<Cookie> basket = new ArrayList<>();

    @GetMapping("/")
    public String index(HttpSession session){
        return "index";
    }

    @GetMapping("/basket")
    public String basket(HttpSession session){
        session.getAttribute("basket");
        return "basket";
    }

    @GetMapping("/shop")
    public String basket(HttpSession session, Model cookieModel){
        cookieModel.addAttribute("cookies",repo.getAllCookies());
        return "shop";
    }

    @GetMapping("/addToBasket")
    public String add(@RequestParam String id, HttpSession session){
        var c = repo.getCookieById(Integer.parseInt(id));

        basket.add(c);
        System.out.println(basket);

        session.setAttribute("basket", basket);
        System.out.println(session.getAttribute("basket"));

        return "redirect:/shop";
    }
}
