package com.ua.sutty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/myCookie")
public class MyCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }

        Cookie cookie = new Cookie("hello", "world");
        cookie.setMaxAge(30);
//        add path cookie
        cookie.setPath("/myCookie");
        cookie.setDomain("my.localhost.com");
//        only https
        cookie.setSecure(true);
        resp.addCookie(cookie);
    }
}
