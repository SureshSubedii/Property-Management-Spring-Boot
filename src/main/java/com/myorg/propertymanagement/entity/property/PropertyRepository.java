package com.myorg.propertymanagement.entity.property;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findAllByManagerId(Long managerId);
    Optional<Property> findByIdAndManagerId(Long id, Long managerId);
}
