package com.myorg.propertymanagement.manager.dto;

import com.myorg.propertymanagement.dto.ApiResponseDto;
import com.myorg.propertymanagement.manager.Manager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponseDto extends ApiResponseDto {
    private Manager data = null;
}

