package com.myorg.propertymanagement.entity.manager;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myorg.propertymanagement.entity.manager.dto.ManagerDto;
import com.myorg.propertymanagement.entity.property.Property;
import com.myorg.propertymanagement.entity.role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "manager", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
@NoArgsConstructor

public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    @JsonIgnore
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "manager")
    @JsonIgnore
    private List<Property> properties;


    public Manager(ManagerDto dto){
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.role = dto.getRole();
    }
    @Override
    public String toString() {
        return "Manager{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
