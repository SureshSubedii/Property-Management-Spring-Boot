package com.myorg.propertymanagement.property;

import com.myorg.propertymanagement.property.dto.CreatePropertyDto;
import com.myorg.propertymanagement.property.dto.DeletePropertyDto;
import com.myorg.propertymanagement.property.dto.UpdatePropertyDto;
import com.myorg.propertymanagement.manager.Manager;
import com.myorg.propertymanagement.manager.ManagerServiceImpl;
import com.myorg.propertymanagement.manager.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    ManagerRepository managerRepository;

    public Long verifyTokenAndGetId(String token){

        if(ManagerServiceImpl.loggedInUsers.containsKey(token)) {
            return ManagerServiceImpl.loggedInUsers.get(token);
        }
        return null;
    }
    public Property addProperty(CreatePropertyDto dto){
        Long managerId = verifyTokenAndGetId(dto.getToken());
        if(managerId == null){
            throw new IllegalArgumentException();
        }
        Manager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new IllegalArgumentException("Manager not found with ID: " + managerId));

        return this.propertyRepository.save(new Property(dto, manager));

    }
    public String deleteProperty(DeletePropertyDto dto){
        Long managerId = verifyTokenAndGetId(dto.getToken());
        Property property = this.propertyRepository.findByIdAndManagerId(dto.getPropertyId(), managerId).orElseThrow(IllegalArgumentException::new);
        if(managerId == null){
            throw new IllegalArgumentException();
        }
        this.propertyRepository.deleteById(property.getId());
        return "Deleted Successfully";
    }

    public Property updateProperty(UpdatePropertyDto dto){
        Long managerId = verifyTokenAndGetId(dto.getToken());
        Property property = this.propertyRepository.findByIdAndManagerId(dto.getPropertyId(), managerId).orElseThrow(IllegalArgumentException::new);

        if(managerId == null){
            throw new IllegalArgumentException();
        }
        property.setCity(dto.getCity());
        property.setDescription(dto.getDescription());
        property.setStreet(dto.getStreet());
        return  this.propertyRepository.save(property);
    }

    public List<Property> listProperties(String token){
        Long managerId = verifyTokenAndGetId(token);
        if(managerId == null){
            throw new IllegalArgumentException();
        }

        return this.propertyRepository.findAllByManagerId(managerId);

    }
}
