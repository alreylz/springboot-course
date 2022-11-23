package com.alreylz.springbootcourse.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringSecurityController {

    @RequestMapping("/helloAll")
    public @ResponseBody
    String greeting1() {
        return "Hello to all people authenticated";
    }


    @RequestMapping("/helloOnlyAdmin")
    public @ResponseBody
    String greeting2() {
        return "Hello only to admins";
    }

}
