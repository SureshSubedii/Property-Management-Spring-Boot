package com.myorg.propertymanagement.entity.role;

import com.myorg.propertymanagement.entity.role.dto.RoleDto;
import com.myorg.propertymanagement.entity.role.dto.RoleResponse;
import com.myorg.propertymanagement.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {
    @Autowired
    RoleFacade roleFacade;

    @PostMapping("/")
    public ResponseEntity<RoleResponse> addRole(@RequestBody RoleDto role){
        return ResponseEntity.ok(roleFacade.handleAddRole(role));

    }
}
