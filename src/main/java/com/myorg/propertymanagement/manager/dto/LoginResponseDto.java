package com.myorg.propertymanagement.manager.dto;

import com.myorg.propertymanagement.dto.ApiResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto  extends ApiResponseDto {
    private String token;
}
