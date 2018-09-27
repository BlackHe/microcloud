package com.peony.microcloudstock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageErrorController {

    @RequestMapping("errorPage")
    public String error(){
        return "error";
    }
}
