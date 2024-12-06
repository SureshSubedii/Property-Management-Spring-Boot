package com.myorg.propertymanagement.entity.manager;

import com.myorg.propertymanagement.entity.manager.dto.ManagerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepository managerRepository;


    public Manager createManager(Manager manager){
        return managerRepository.save(manager);
    }

    public Optional<Manager> findManager(String email, String password){
        return managerRepository.findByEmailAndPassword(email, password);
    }



}
