package com.lynas.controller;

import com.lynas.model.AppUser;
import com.lynas.model.AppUserRole;
import com.lynas.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by sazzad on 2/11/16.
 */
@Controller
public class HomeController {

    @Autowired
    AppUserService appUserService;


    @RequestMapping(value = "/")
    public String home(){

        return "home";
    }

    @RequestMapping(value = "/addAppUser")
    public String addAppUser(){
        appUserService.insertAppUser(new AppUser(1, "user", "pass", new ArrayList<AppUserRole>()));
        return "home";
    }
}
