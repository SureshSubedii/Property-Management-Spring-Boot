package com.myorg.propertymanagement.entity.manager;

import com.myorg.propertymanagement.entity.manager.dto.LoginResponse;
import com.myorg.propertymanagement.entity.manager.dto.SignUpResponse;
import com.myorg.propertymanagement.entity.manager.dto.ManagerDto;
import com.myorg.propertymanagement.entity.role.Role;
import com.myorg.propertymanagement.entity.role.RoleFacade;
import com.myorg.propertymanagement.entity.role.RoleService;
import com.myorg.propertymanagement.security.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
@Slf4j
public class ManagerFacade  {

    @Autowired
    ManagerService managerService;

    @Autowired
    RoleFacade roleFacade;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public SignUpResponse handleSignup(ManagerDto body) {
        SignUpResponse response = new SignUpResponse();
        try {
            body.setPassword(encoder.encode(body.getPassword()));
            body.setRole(roleFacade.findOrCreateRole(body.getRoleName()));
            Manager newManager = managerService.createManager(new Manager(body));
            response.setData(newManager);
            response.setSuccess(true);
            response.setMessage("Signup Successfull");
        } catch (DataIntegrityViolationException e) {
            response.setMessage("Email already registered.");
            response.setSuccess(false);
            log.error("Duplicate Email: {}", body);

        }
        return response;

    }

    public LoginResponse handleLogin(ManagerDto body) {
        LoginResponse response = new LoginResponse();


        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword())
            );
            if (authentication.isAuthenticated()) {
                response.setToken(jwtService.generateToken(body.getEmail()));
                response.setSuccess(true);
                response.setMessage("Login Successful");

            }
        } catch (IllegalArgumentException e) {
            response.setMessage("Invalid email or password");
            log.error("Login Failed due to wrong username or password.Parameters: {}", body);

        }
        return response;

    }

}

