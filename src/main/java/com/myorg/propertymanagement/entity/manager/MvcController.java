package com.myorg.propertymanagement.entity.manager;


import com.myorg.propertymanagement.entity.manager.dto.LoginResponse;
import com.myorg.propertymanagement.entity.manager.dto.ManagerDto;
import com.myorg.propertymanagement.entity.manager.dto.SignUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("managers")
public class MvcController {
    @Autowired
    ManagerFacade managerFacade;

    @GetMapping("/")
    public String showSignupForm(){
        return "signupForm";
    }
    @GetMapping("/form")
    public String showLoginForm(){
        return "loginForm";
    }

    @PostMapping("/signup")
    public String handleFormSubmission(@ModelAttribute ManagerDto managerDto, Model model){
        SignUpResponse response = managerFacade.handleSignup(managerDto);
        model.addAttribute("message", response.getMessage());
        return "successPage";
    }
    @PostMapping("/auth")
    public String login(@ModelAttribute ManagerDto managerDto, Model model){
        LoginResponse  response=  managerFacade.handleLogin(managerDto);
        model.addAttribute("message", response.getMessage());
        return "successPage";
}
}