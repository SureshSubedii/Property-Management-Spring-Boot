package com.myorg.propertymanagement.property;


import com.myorg.propertymanagement.property.dto.CreatePropertyDto;
import com.myorg.propertymanagement.property.dto.DeletePropertyDto;
import com.myorg.propertymanagement.property.dto.UpdatePropertyDto;

import java.util.List;

public interface PropertyService {
    Property addProperty(CreatePropertyDto propertyDto);
    String deleteProperty(DeletePropertyDto propertyDto);
    Property updateProperty(UpdatePropertyDto propertyDto);
    List<Property> listProperties(String token);
}
