package com.myorg.propertymanagement.entity.property.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeletePropertyDto {
    private String token;
    private long propertyId;
}
