package com.myorg.propertymanagement.entity.manager.dto;

import com.myorg.propertymanagement.response.ApiResponse;
import com.myorg.propertymanagement.entity.manager.Manager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponse extends ApiResponse {
    private Manager data = null;
}

