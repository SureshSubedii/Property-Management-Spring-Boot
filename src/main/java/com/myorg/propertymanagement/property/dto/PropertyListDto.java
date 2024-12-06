package com.myorg.propertymanagement.property.dto;

import com.myorg.propertymanagement.dto.ApiResponseDto;
import com.myorg.propertymanagement.property.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyListDto extends ApiResponseDto {
    private List<Property> propertiesYouManage;
}
