package com.example.rentalsystem.repository;

import com.example.rentalsystem.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {}