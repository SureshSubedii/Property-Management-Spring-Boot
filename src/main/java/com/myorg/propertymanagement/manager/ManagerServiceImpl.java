package com.myorg.propertymanagement.manager;

import com.myorg.propertymanagement.manager.dto.ManagerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    public  static final Map<String, Long> loggedInUsers = new HashMap<>();

    public Manager createManager(ManagerDto dto){
        return managerRepository.save(new Manager(dto));
    }

    public String login(ManagerDto manager){
        Manager loggedManager =  managerRepository.findByEmailAndPassword(manager.getEmail(), manager.getPassword()).orElseThrow(()-> new IllegalArgumentException("Invalid email or password"));
        String token = randomStringGenerator();
        loggedInUsers.put(token, loggedManager.getId());
        System.out.println(loggedInUsers);
        return token;
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
