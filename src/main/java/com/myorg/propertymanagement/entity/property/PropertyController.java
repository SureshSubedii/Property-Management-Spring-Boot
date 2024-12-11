package com.myorg.propertymanagement.entity.property;

import com.myorg.propertymanagement.response.ApiResponse;
import com.myorg.propertymanagement.entity.property.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @DeleteMapping("/{propertyId}")
    public ResponseEntity<ApiResponse> deleteProperty(@PathVariable Long propertyId) {
        return ResponseEntity.ok(propertyFacade.handleDeleteProperty(propertyId));
    }

    @PutMapping("/")
    public ResponseEntity<ApiResponse> updateProperty(@RequestBody UpdatePropertyDto body) {
        return ResponseEntity.ok(propertyFacade.handleUpdateProperty(body));
    }

    @GetMapping("/")
    public ResponseEntity<PropertyList> listProperties( ) {
        return ResponseEntity.ok(propertyFacade.handleListProperties());
    }
    @GetMapping("/ALL")
    public ResponseEntity<PropertyList> allProperties( ) {
        return ResponseEntity.ok(propertyFacade.handleListProperties());
    }

//    @PreAuthorize("hasAuthorithy('ADMIN')")
}

