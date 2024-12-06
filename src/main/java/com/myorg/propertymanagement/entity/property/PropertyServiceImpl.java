package com.myorg.propertymanagement.entity.property;

import com.myorg.propertymanagement.entity.manager.Manager;
import com.myorg.propertymanagement.entity.manager.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    ManagerRepository managerRepository;


    public Property addProperty(Property property){
        return this.propertyRepository.save(property);
    }

    public Optional<Manager> findManager(Long managerId){
       return managerRepository.findById(managerId);

    }

    public void deleteProperty(Long propertyId){
        this.propertyRepository.deleteById(propertyId);
    }

    public Property updateProperty(Property property){
        return  this.propertyRepository.save(property);
    }

    public Optional<Property> findRightProperty(Long managerId, Long propertyId){
      return  this.propertyRepository.findByIdAndManagerId(propertyId, managerId);
    }


    public List<Property> listProperties(Long managerId){
        return this.propertyRepository.findAllByManagerId(managerId);

    }
}
