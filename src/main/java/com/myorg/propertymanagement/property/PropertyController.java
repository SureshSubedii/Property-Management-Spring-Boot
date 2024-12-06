package com.myorg.propertymanagement.property;

import com.myorg.propertymanagement.dto.ApiResponseDto;
import com.myorg.propertymanagement.property.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/property")
public class PropertyController {

    @Autowired
    private PropertyFacade propertyFacade;

    @PostMapping("/")
    public ResponseEntity<NewPropertyResponseDto> addProperty(@RequestBody CreatePropertyDto body) {
        return ResponseEntity.ok(propertyFacade.handleAddProperty(body));
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponseDto> deleteProperty(@RequestBody DeletePropertyDto body) {
        return ResponseEntity.ok(propertyFacade.handleDeleteProperty(body));
    }

    @PutMapping("/")
    public ResponseEntity<ApiResponseDto> updateProperty(@RequestBody UpdatePropertyDto body) {
        return ResponseEntity.ok(propertyFacade.handleUpdateProperty(body));
    }

    @GetMapping("/{token}")
    public ResponseEntity<PropertyListDto> listProperties(@PathVariable String token) {
        return ResponseEntity.ok(propertyFacade.handleListProperties(token));
    }
}

