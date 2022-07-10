package edu.mum.cs.cs425.demowebapps.eregistrar.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping(value = { "/public/login", "/eregistrar/public/login" })
    public String displayLoginPage() {
        return "public/login/login";
    }

    @PostMapping(value = { "/public/logout", "/eregistrar/public/logout" })
    public String doLogout(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException {
        request.logout();
        return "redirect:/eregistrar/public/login?logout";
    }
}
