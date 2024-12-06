package com.myorg.propertymanagement.property.dto;

import com.myorg.propertymanagement.dto.ApiResponseDto;
import com.myorg.propertymanagement.property.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewPropertyResponseDto  extends ApiResponseDto {
    private Property property;
}
