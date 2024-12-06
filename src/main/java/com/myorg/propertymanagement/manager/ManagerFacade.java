package com.myorg.propertymanagement.manager;

import com.myorg.propertymanagement.manager.dto.LoginResponseDto;
import com.myorg.propertymanagement.manager.dto.SignUpResponseDto;
import com.myorg.propertymanagement.manager.dto.ManagerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ManagerFacade {

    @Autowired
    ManagerService managerService;

    public SignUpResponseDto handleSignup(ManagerDto body) {
        SignUpResponseDto response = new SignUpResponseDto();
        try {
            Manager newManager = managerService.createManager(body);
            response.setData(newManager);
            response.setSuccess(true);
        } catch (DataIntegrityViolationException e) {
            response.setMessage("Email already registered.");
        }
        return response;

    }

    public LoginResponseDto handleLogin(ManagerDto body) {
        LoginResponseDto response = new LoginResponseDto();

        try {
            String token = managerService.login(body);
            response.setMessage("Login Successful");
            response.setSuccess(true);
            response.setToken(token);
        } catch (IllegalArgumentException e) {
            response.setMessage("Invalid email or password");
        }
        return response;

    }
}

