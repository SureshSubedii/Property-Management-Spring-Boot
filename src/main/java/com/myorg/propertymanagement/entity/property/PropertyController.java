package com.myorg.propertymanagement.entity.property;

import com.myorg.propertymanagement.response.ApiResponse;
import com.myorg.propertymanagement.entity.property.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/property")
public class PropertyController {

    @Autowired
    private PropertyFacade propertyFacade;

    @PostMapping("/")
    public ResponseEntity<NewPropertyResponse> addProperty(@RequestBody CreatePropertyDto body) {
        return ResponseEntity.ok(propertyFacade.handleAddProperty(body));
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse> deleteProperty(@RequestBody DeletePropertyDto body) {
        return ResponseEntity.ok(propertyFacade.handleDeleteProperty(body));
    }

    @PutMapping("/")
    public ResponseEntity<ApiResponse> updateProperty(@RequestBody UpdatePropertyDto body) {
        return ResponseEntity.ok(propertyFacade.handleUpdateProperty(body));
    }

    @GetMapping("/{token}")
    public ResponseEntity<PropertyList> listProperties(@PathVariable String token) {
        return ResponseEntity.ok(propertyFacade.handleListProperties(token));
    }
}

