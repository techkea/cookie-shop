package com.example.cookieshop.services;

import com.example.cookieshop.models.Cookie;

import java.util.List;

public class CookieService {

    public String calculatePrice(List<Cookie> c){
        var sum = 0;
        for (Cookie i: c) {
            sum += i.getPrice();
        }
        return Integer.toString(i);
    }
}
