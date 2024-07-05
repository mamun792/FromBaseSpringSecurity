package com.mahababub.security.MyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityCintroller {

    @GetMapping("/")
    public  String Register(){
        return "Register";
    }

    @PostMapping("/login")
    public  String Login(){
        return "Login";
    }
}
