package com.intelematics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Ian on 2/28/2016.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage() {
        return "index";
    }
}
