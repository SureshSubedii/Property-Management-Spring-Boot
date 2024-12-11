package com.myorg.propertymanagement.entity.manager.dto;

import com.myorg.propertymanagement.entity.role.Role;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ManagerDto {
    private String email;
    private String password;
    private Role role;

    @Override
    public String toString() {
        return "email = " + email + " password = " + password;
    }


}
