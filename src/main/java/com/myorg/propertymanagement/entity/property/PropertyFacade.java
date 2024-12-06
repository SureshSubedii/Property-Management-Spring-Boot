package com.myorg.propertymanagement.entity.property;

import com.myorg.propertymanagement.entity.manager.Manager;
import com.myorg.propertymanagement.entity.manager.ManagerFacade;
import com.myorg.propertymanagement.response.ApiResponse;
import com.myorg.propertymanagement.entity.property.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyFacade {

    @Autowired
    private PropertyService propertyService;

    public NewPropertyResponse handleAddProperty(CreatePropertyDto body) {
        NewPropertyResponse response = new NewPropertyResponse();
        try {
            Long managerId = verifyTokenAndGetId(body.getToken());
            if(managerId == null){
                throw new IllegalArgumentException();
            }
            Manager manager = propertyService.findManager(managerId);
            Property newProperty = propertyService.addProperty(new Property(body, manager));
            response.setMessage("Property Added Successfully");
            response.setProperty(newProperty);
            response.setSuccess(true);
        } catch (IllegalArgumentException e) {
            response.setMessage("You are not logged in");
        }
        return response;
    }

    public ApiResponse handleDeleteProperty(DeletePropertyDto body) {
        ApiResponse response = new ApiResponse();
        try {
            Long managerId = verifyTokenAndGetId(body.getToken());
            if(managerId == null){
                throw new IllegalArgumentException();
            }
            System.out.println(managerId);

            propertyService.deleteProperty(body.getPropertyId(), managerId);
            response.setMessage("Property Deleted Successfully");
            response.setSuccess(true);
        } catch (IllegalArgumentException e) {
            response.setMessage("Access Denied");
        }
        return response;

    }

    public NewPropertyResponse handleUpdateProperty(UpdatePropertyDto body) {
        NewPropertyResponse response = new NewPropertyResponse();
        try {
            Long managerId = verifyTokenAndGetId(body.getToken());
            Property property = new Property();

            if(managerId == null){
                throw new IllegalArgumentException();
            }
            Property existingProperty = propertyService.findRightProperty(managerId, body.getPropertyId());
            property.setCity(body.getCity());
            property.setDescription(body.getDescription());
            property.setStreet(body.getStreet());
            response.setProperty(propertyService.updateProperty(existingProperty));
            response.setSuccess(true);
            response.setMessage("Property Updated Successfully");


        } catch (IllegalArgumentException e) {
            response.setMessage("Access Denied");
        }
        return response;
    }

    public PropertyList handleListProperties(String token) {
        PropertyList response = new PropertyList();
        try {
            Long managerId = verifyTokenAndGetId(token);
            if(managerId == null){
                throw new IllegalArgumentException();
            }
            response.setPropertiesYouManage(propertyService.listProperties(managerId));

            response.setSuccess(true);
            response.setMessage("List Fetched Successfully");

        } catch (IllegalArgumentException e) {
            response.setMessage("You are not logged in");
        }
        return response;
    }


    public Long verifyTokenAndGetId(String token){

        if(ManagerFacade.loggedInUsers.containsKey(token)) {
            return ManagerFacade.loggedInUsers.get(token);
        }
        return null;
    }
}

