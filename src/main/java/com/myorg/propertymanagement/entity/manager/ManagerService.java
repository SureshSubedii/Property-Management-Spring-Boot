package com.myorg.propertymanagement.entity.manager;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ManagerService {
    Manager createManager(Manager manager);
    Optional<Manager> findManager(String email, String password);
    Optional<Manager> findByEmail(String email);
    Object findManagerWithProperties();

}


