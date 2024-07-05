package com.mahababub.security.MyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityCintroller {

    @GetMapping({"/", "/login"})
    public String Register() {
        return "Login";
    }

    @GetMapping("/user/register")
    public String userRegistrationPage() {
        return "Register";
    }

    @GetMapping("/admin/register")
    public String adminRegistrationPage() {
        return "AdminRegi";
    }

    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "UserDash";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "AdminDash";
    }
}

