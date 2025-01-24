package com.example.rentalsystem.service;

import com.example.rentalsystem.model.Property;
import com.example.rentalsystem.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElseThrow();
    }

    public void rentProperty(Long id) {
        Property property = getPropertyById(id);
        property.rent();
        propertyRepository.save(property);
    }

    public void unrentProperty(Long id) {
        Property property = getPropertyById(id);
        property.unrent();
        propertyRepository.save(property);
    }
}