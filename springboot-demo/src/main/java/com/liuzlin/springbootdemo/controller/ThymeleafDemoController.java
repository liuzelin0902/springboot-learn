package com.liuzlin.springbootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/thymeleaf-demo")
public class ThymeleafDemoController {
    private static final Logger logger =
            LoggerFactory.getLogger(ThymeleafDemoController.class);

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "liuzelin, Model");
        logger.info("hello info");
        logger.warn("hello warn");
        return "index";
    }

    @GetMapping("/index1")
    public ModelAndView index1(ModelAndView view) {
        view.setViewName("index");
        view.addObject("title", "liuzelin, ModelAndView");
        return view;
    }

    @GetMapping("/index2")
    public String index2(HashMap map) {
        map.put("title", "liuzelin, HashMap");
        return "index";
    }

    @GetMapping("/index3")
    public String index3(HttpServletRequest request) {
        request.setAttribute("title", "liuzelin, HttpServletRequest");
        return "index";
    }
}
