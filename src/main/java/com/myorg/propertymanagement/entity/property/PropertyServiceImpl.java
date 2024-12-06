package com.myorg.propertymanagement.entity.property;

import com.myorg.propertymanagement.entity.manager.ManagerFacade;
import com.myorg.propertymanagement.entity.property.dto.CreatePropertyDto;
import com.myorg.propertymanagement.entity.property.dto.DeletePropertyDto;
import com.myorg.propertymanagement.entity.property.dto.UpdatePropertyDto;
import com.myorg.propertymanagement.entity.manager.Manager;
import com.myorg.propertymanagement.entity.manager.ManagerServiceImpl;
import com.myorg.propertymanagement.entity.manager.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    ManagerRepository managerRepository;


    public Property addProperty(Property property){
        return this.propertyRepository.save(property);
    }

    public Manager findManager(Long managerId){
       return managerRepository.findById(managerId)
                .orElseThrow(() -> new IllegalArgumentException("Manager not found with ID: " + managerId));
    }

    public void deleteProperty(Long propertyId, Long managerId){
        Property property = this.propertyRepository.findByIdAndManagerId(propertyId, managerId).orElseThrow(IllegalArgumentException::new);
        this.propertyRepository.deleteById(property.getId());
    }

    public Property updateProperty(Property property){
        return  this.propertyRepository.save(property);
    }

    public Property findRightProperty(Long managerId, Long propertyId){
      return  this.propertyRepository.findByIdAndManagerId(propertyId, managerId).orElseThrow(IllegalArgumentException::new);
    }


    public List<Property> listProperties(Long managerId){
        return this.propertyRepository.findAllByManagerId(managerId);

    }
}
