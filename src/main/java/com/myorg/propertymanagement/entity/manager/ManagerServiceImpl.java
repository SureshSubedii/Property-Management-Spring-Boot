package com.myorg.propertymanagement.entity.manager;

import com.myorg.propertymanagement.entity.manager.dto.ManagerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepository managerRepository;


    public Manager createManager(Manager manager){
        return managerRepository.save(manager);
    }

    public Manager login(ManagerDto manager){
        return managerRepository.findByEmailAndPassword(manager.getEmail(), manager.getPassword()).orElseThrow(()-> new IllegalArgumentException("Invalid email or password"));
    }



}
