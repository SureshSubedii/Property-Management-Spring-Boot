package com.myorg.propertymanagement.entity.manager.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ManagerDto {
    private String email;
    private String password;

    @Override
    public String toString() {
        return "email = " + email + " password = " + password;
    }


}
