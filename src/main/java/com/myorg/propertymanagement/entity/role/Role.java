package com.myorg.propertymanagement.entity.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myorg.propertymanagement.entity.manager.Manager;
import com.myorg.propertymanagement.entity.role.dto.RoleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<Manager> manager;

    public Role(RoleDto role){
        this.name = role.getName();
    }

}
