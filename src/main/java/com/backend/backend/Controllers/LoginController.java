package com.backend.backend.Controllers;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backend.backend.Entities.LoginEntity;
import com.backend.backend.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;


    @GetMapping("/login")

    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new LoginEntity());
        return mav;
    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity<String> login(@PathVariable("username") String username, @PathVariable("password") String password ) {

        LoginEntity user = new LoginEntity(username, password);
        LoginEntity oauthUser = loginService.login(user.getUsername(), user.getPassword());


        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return ResponseEntity.ok("FUNCIONA");
        }
        return ResponseEntity.ok("xd");
    }
/*
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {


        return "redirect:/login";
    }
*/
}