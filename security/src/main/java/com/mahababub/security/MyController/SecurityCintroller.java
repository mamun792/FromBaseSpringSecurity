package com.mahababub.security.MyController;


import com.mahababub.security.model.User;
import com.mahababub.security.services.UserServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SecurityCintroller {

    private  final UserServiceImp userService;

    public SecurityCintroller(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/login"})
    public String loginPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && error.equals("true")) {
            model.addAttribute("error", "Invalid Credentials!");
        }
        return "Login";
    }

    @GetMapping("/user/register")
    public String userRegistrationPage() {
        return "Register";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request) {

        System.out.println(request.isUserInRole("ROLE_ADMIN"));
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/dashboard";
        }

        return "redirect:/user/dashboard";
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

    @PostMapping("/user/register")
    public String registerUser(User user, RedirectAttributes redirectAttributes) {
        if (userService.findByUsername(user.getUsername()) != null) {
            redirectAttributes.addFlashAttribute("error", "User already exists with username: " + user.getUsername());
            return "redirect:/user/register";
        }
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("success", "Registration successful");

        return "redirect:/user/register";
    }

    @PostMapping("/admin/register")
    public String registerAdmin(User user, RedirectAttributes redirectAttributes) {
        if (userService.findByUsername(user.getUsername()) != null) {
            redirectAttributes.addFlashAttribute("error", "User already exists with username: " + user.getUsername());
            return "redirect:/admin/register";
        }
        userService.saveAdmin(user);
        redirectAttributes.addFlashAttribute("success", "Registration successful");

        return "redirect:/admin/register";
    }
}

