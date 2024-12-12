package com.myorg.propertymanagement.entity.property;


import com.myorg.propertymanagement.entity.manager.Manager;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    Property addProperty(Property property);
    void deleteProperty(Long propertyId);
    Property updateProperty(Property property);
    List<Property> listProperties(Long managerId);
    Optional<Manager> findManager(Long managerId);
    Optional<Property> findRightProperty(Long managerId, Long propertyId);
    List<Property> findAllProperty();
}
