package com.example.rentalsystem.controller;

import com.example.rentalsystem.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PropertyController {
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/e")
    public String index(Model model) {
        model.addAttribute("properties", propertyService.getAllProperties());
        return "index"; // Szuka pliku "index.html" w folderze "resources/templates"
    }

    @PostMapping("/rent")
    public String rentProperty(@RequestParam Long id, Model model) {
        propertyService.rentProperty(id);
        model.addAttribute("properties", propertyService.getAllProperties()); // Dodaj zaktualizowaną listę
        return "index"; // Zwróć zaktualizowany widok z listą mieszkań
    }

    @PostMapping("/unrent")
    public String unrentProperty(@RequestParam Long id, Model model) {
        propertyService.unrentProperty(id);
        model.addAttribute("properties", propertyService.getAllProperties()); // Dodaj zaktualizowaną listę
        return "index"; // Zwróć zaktualizowany widok z listą mieszkań
    }
}