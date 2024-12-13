package com.myorg.propertymanagement.entity.manager;


import com.myorg.propertymanagement.entity.manager.dto.LoginResponse;
import com.myorg.propertymanagement.entity.manager.dto.ManagerDto;
import com.myorg.propertymanagement.entity.manager.dto.SignUpResponse;
import com.myorg.propertymanagement.entity.property.PropertyFacade;
import com.myorg.propertymanagement.entity.property.dto.CreatePropertyDto;
import com.myorg.propertymanagement.entity.property.dto.UpdatePropertyDto;
import com.myorg.propertymanagement.security.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class MvcController {
    @Autowired
    ManagerFacade managerFacade;

    @Autowired
    JwtService jwtService;

    @Autowired
    PropertyFacade propertyFacade;

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
        model.addAttribute("success", response.isSuccess());

        return "loginForm";
    }
    @PostMapping("/auth")
    public String login(@ModelAttribute ManagerDto managerDto, Model model, HttpServletResponse response){
        LoginResponse  results=  managerFacade.handleLogin(managerDto);
        model.addAttribute("message", results.getMessage());
        model.addAttribute("success", results.isSuccess());
        Cookie cookie = new Cookie("JWT_TOKEN", results.getToken());
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        return "redirect:/properties";
}

@GetMapping("/properties")
public String getProperties( Model model) {
        model.addAttribute("properties", propertyFacade.handleListProperties().getPropertiesYouManage());
    return "propertyListing";
}

    @GetMapping("/properties/form")
    public String showEditForm(@RequestParam(value = "id", required = false) Long id ,
                               @RequestParam(value = "street", required = false) String street,
                               @RequestParam(value = "city", required = false) String city,
                               @RequestParam(value = "description", required = false) String description,
                               Model model) {
        model.addAttribute("id", id);
        model.addAttribute("street", street);
        model.addAttribute("city", city);
        model.addAttribute("description", description);
        return "editForm";
    }

    @PostMapping("/properties/add")
    public String addProperty(@ModelAttribute CreatePropertyDto body, RedirectAttributes redirectAttributes) {
        this.propertyFacade.handleAddProperty(body);
        redirectAttributes.addFlashAttribute("message", "Property Added Successfully");
        return "redirect:/properties";
    }


        @PostMapping("/properties")
    public String updateProperties(@ModelAttribute UpdatePropertyDto body, RedirectAttributes redirectAttributes) {
        this.propertyFacade.handleUpdateProperty(body);
        redirectAttributes.addFlashAttribute("message", "Update Successfully");
        return "redirect:/properties";


    }

}

