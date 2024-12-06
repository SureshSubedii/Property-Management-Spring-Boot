package com.myorg.propertymanagement.entity.manager;

import com.myorg.propertymanagement.entity.manager.dto.LoginResponse;
import com.myorg.propertymanagement.entity.manager.dto.SignUpResponse;
import com.myorg.propertymanagement.entity.manager.dto.ManagerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class ManagerFacade {

    @Autowired
    ManagerService managerService;

    public  static final Map<String, Long> loggedInUsers = new HashMap<>();


    public SignUpResponse handleSignup(ManagerDto body) {
        SignUpResponse response = new SignUpResponse();
        try {
            Manager newManager = managerService.createManager(new Manager(body));
            response.setData(newManager);
            response.setSuccess(true);
        } catch (DataIntegrityViolationException e) {
            response.setMessage("Email already registered.");
        }
        return response;

    }

    public LoginResponse handleLogin(ManagerDto body) {
        LoginResponse response = new LoginResponse();

        try {
            Manager loggedManager = managerService.login(body);
            String token = randomStringGenerator();
            loggedInUsers.put(token, loggedManager.getId());
            System.out.println(loggedInUsers);
            response.setMessage("Login Successful");
            response.setSuccess(true);
            response.setToken(token);
        } catch (IllegalArgumentException e) {
            response.setMessage("Invalid email or password");
        }
        return response;

    }
    public String randomStringGenerator(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 8;
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString();
    }
}

