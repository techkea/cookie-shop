package com.example.cookieshop.services;

import com.example.cookieshop.models.Cookie;

import java.util.List;

public class CookieService {

    // Add functionality such that the basket page displays the total sum of the price of cookies in his/hers basket

    public String calculatePrice(List<Cookie> c){
        var sum = 0;
        for (Cookie i: c) {
            sum += i.getPrice();
        }
        return Integer.toString(sum);
    }

    public String itemsInBasket(List<Cookie> c){
        return Integer.toString(c.size());
    }
}
