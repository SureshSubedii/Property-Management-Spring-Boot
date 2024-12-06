package com.myorg.propertymanagement.property;

import com.myorg.propertymanagement.dto.ApiResponseDto;
import com.myorg.propertymanagement.property.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PropertyFacade {

    @Autowired
    private PropertyService propertyService;

    public NewPropertyResponseDto handleAddProperty(CreatePropertyDto body) {
        NewPropertyResponseDto response = new NewPropertyResponseDto();
        try {
            Property newProperty = propertyService.addProperty(body);
            response.setMessage("Property Added Successfully");
            response.setProperty(newProperty);
            response.setSuccess(true);
        } catch (IllegalArgumentException e) {
            response.setMessage("You are not logged in");
        }
        return response;
    }

    public ApiResponseDto handleDeleteProperty(DeletePropertyDto body) {
        ApiResponseDto response = new ApiResponseDto();
        try {
            response.setMessage(propertyService.deleteProperty(body));
            response.setSuccess(true);
        } catch (IllegalArgumentException e) {
            response.setMessage("Access Denied");
        }
        return response;

    }

    public NewPropertyResponseDto handleUpdateProperty(UpdatePropertyDto body) {
        NewPropertyResponseDto response = new NewPropertyResponseDto();
        try {
            response.setMessage("Property Updated Successfully");
            response.setProperty(propertyService.updateProperty(body));
            response.setSuccess(true);

        } catch (IllegalArgumentException e) {
            response.setMessage("Access Denied");
        }
        return response;
    }

    public PropertyListDto handleListProperties(String token) {
        PropertyListDto response = new PropertyListDto();
        try {
            response.setPropertiesYouManage(propertyService.listProperties(token));
            response.setSuccess(true);
            response.setMessage("List Fetched Successfully");

        } catch (IllegalArgumentException e) {
            response.setMessage("You are not logged in");
        }
        return response;
    }
}

