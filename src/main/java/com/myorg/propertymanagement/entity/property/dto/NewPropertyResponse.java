package com.myorg.propertymanagement.entity.property.dto;

import com.myorg.propertymanagement.response.ApiResponse;
import com.myorg.propertymanagement.entity.property.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewPropertyResponse extends ApiResponse {
    private Property property;
}
