package com.myorg.propertymanagement.entity.role;

import com.myorg.propertymanagement.entity.role.dto.RoleDto;
import com.myorg.propertymanagement.entity.role.dto.RoleResponse;
import com.myorg.propertymanagement.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class RoleFacade {
    @Autowired
    RoleService roleService;
    public RoleResponse handleAddRole(RoleDto role){
        RoleResponse response = new RoleResponse();
        try {
            response.setRole(roleService.addRole(new Role(role)));
            response.setMessage("Role added successfully");
            response.setSuccess(true);
        }

        catch (DataIntegrityViolationException e) {
            response.setMessage("Role Already Exists");
            response.setSuccess(false);


        }

        return response;

    }
    public Role findOrCreateRole(String name) {
        return roleService.findRole(name).orElseGet(() -> {
            Role newRole = new Role();
            newRole.setName(name);
            return roleService.addRole(newRole);
        });
    }

}
