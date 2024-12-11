package com.myorg.propertymanagement.entity.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements  RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role addRole(Role role){
        return this.roleRepository.save(role);
    }
    public Optional<Role> findRole(String name){
        return this.roleRepository.findRoleByName(name);

    }
}
