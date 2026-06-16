package com.metrowest.controllers.roles;

import com.metrowest.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    private final UserRepository userRepository;

    public AdminController(@Autowired UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping("/dashboard")
    public String root(Model model)
    {
        var users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin/dashboard";
    }
}
