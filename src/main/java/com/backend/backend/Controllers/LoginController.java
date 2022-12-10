package com.backend.backend.Controllers;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backend.backend.Entities.LoginEntity;
import com.backend.backend.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class LoginController {
    @Autowired
    private LoginService userService;


    @GetMapping("/login")

    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new LoginEntity());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") LoginEntity user ) {

        LoginEntity oauthUser = userService.login(user.getUsername(), user.getPassword());


        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {

            return "redirect:/";


        } else {
            return "redirect:/login";


        }

    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {


        return "redirect:/login";
    }

}