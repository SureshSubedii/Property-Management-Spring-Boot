package com.myorg.propertymanagement.property.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatePropertyDto {
    private String token;
    private Long propertyId;
    private  String street;
    private String city;
    private String description;
}
