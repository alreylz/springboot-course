package com.alreylz.springbootcourse.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Provides endpoints to demonstrate the use of views,
 * passing data to them using the Model class
 * It shows how JSPs can still be used in spring to create views
 * <p>
 * [IMPORTANT] Requires uncommenting the Config class
 */
@Controller
public class ViewSamples {

    static final String basePath = "/templating-engines";

    @RequestMapping("/jsp")
    public String test(Model model) {
        model.addAttribute("name", "Hi from a JSP");
        return "jsp-view.jsp";
    }

    @RequestMapping("/th")
    public String test2(Model model) {
        model.addAttribute("name", "Hi from thymeleaf");
        return "thymeleaf-view.html";
    }
}
