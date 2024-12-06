package com.myorg.propertymanagement.entity.manager;


import com.myorg.propertymanagement.entity.manager.dto.ManagerDto;

public interface ManagerService {
    Manager createManager(Manager manager);
    Manager login(ManagerDto manager);
}

