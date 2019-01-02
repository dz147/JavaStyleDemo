package com.dznfit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/loginUser")
    public String login () {
        return "please input your password.";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/policy/view")
    public String policy () {
        return "dangdezhengcehao,nianianchidebao.";
    }
}
