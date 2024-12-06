package com.myorg.propertymanagement.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myorg.propertymanagement.property.dto.CreatePropertyDto;
import com.myorg.propertymanagement.manager.Manager;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String street;
    private  String city;
    private String description;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonIgnore
    private Manager manager;

    public Property(CreatePropertyDto dto, Manager manager) {
        this.street = dto.getStreet();
        this.city = dto.getCity();
        this.description = dto.getDescription();
        this.manager = manager;
    }


}
