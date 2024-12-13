package com.myorg.propertymanagement.entity.manager.dto;

import com.myorg.propertymanagement.response.ApiResponse;
import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse extends ApiResponse {
    private String token;
    private Cookie cookie;
}
