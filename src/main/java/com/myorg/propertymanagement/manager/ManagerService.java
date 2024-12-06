package com.myorg.propertymanagement.manager;


import com.myorg.propertymanagement.manager.dto.ManagerDto;

public interface ManagerService {
    Manager createManager(ManagerDto dto);
    String login(ManagerDto manager);
    String randomStringGenerator();
}

