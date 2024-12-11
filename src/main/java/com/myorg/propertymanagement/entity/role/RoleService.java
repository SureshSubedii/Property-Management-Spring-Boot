package com.myorg.propertymanagement.entity.role;

import java.util.Optional;

public interface RoleService {
    Role addRole(Role role);
    Optional<Role> findRole(String name);
}
