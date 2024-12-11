package com.myorg.propertymanagement.entity.role.dto;

import com.myorg.propertymanagement.entity.role.Role;
import com.myorg.propertymanagement.response.ApiResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponse extends ApiResponse {
    private Role role;
}
