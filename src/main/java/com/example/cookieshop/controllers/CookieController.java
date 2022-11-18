package com.example.cookieshop.controllers;

import com.example.cookieshop.models.Cookie;
import com.example.cookieshop.repositories.CookieRepository;
import com.example.cookieshop.services.CookieService;
import org.apache.catalina.session.StandardSession;
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
    private CookieService service = new CookieService();
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
        if(session.getAttribute("log") == null){
            return "redirect:/";
        }
        cookieModel.addAttribute("cookies",repo.getAllCookies());
        return "shop";
    }
    @GetMapping("/addToBasket")
    public String add(@RequestParam String id, HttpSession ses){
        // Add functionality such that a customer can add cookies to his/her basket and change pages without losing the baskets state
        var c = repo.getCookieById(Integer.parseInt(id));
        basket.add(c);
        ses.setAttribute("basket", basket);

        // Add functionality such that the basket page displays the total sum of the price of cookies in his/hers basket
        ses.setAttribute("sum", service.calculatePrice(basket));
        ses.setAttribute("itemsInBasket", service.itemsInBasket(basket));
        return "redirect:/shop";
    }
}
