package com.myorg.propertymanagement.entity.property;


import com.myorg.propertymanagement.entity.manager.Manager;

import java.util.List;

public interface PropertyService {
    Property addProperty(Property property);
    void deleteProperty(Long propertyId, Long managerId);
    Property updateProperty(Property property);
    List<Property> listProperties(Long managerId);
    Manager findManager(Long managerId);
    Property findRightProperty(Long managerId, Long propertyId);
}
