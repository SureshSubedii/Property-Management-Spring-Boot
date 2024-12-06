package com.myorg.propertymanagement.entity.manager;


import com.myorg.propertymanagement.entity.manager.dto.ManagerDto;

import java.util.Optional;

public interface ManagerService {
    Manager createManager(Manager manager);
    Optional<Manager> findManager(String email, String password);
}

