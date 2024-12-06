package com.myorg.propertymanagement.entity.property.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePropertyDto {
    private  String street;
    private String city;
    private String description;
    private String token;

}
