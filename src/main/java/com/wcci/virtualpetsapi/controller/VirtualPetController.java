package com.wcci.virtualpetsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualpetsapi.entity.VirtualPet;
import com.wcci.virtualpetsapi.service.VirtualPetService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/virtualpets")
public class VirtualPetController {

    @Autowired
    private VirtualPetService virtualPetService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("good test");
    }

    @GetMapping
    public ResponseEntity<List<VirtualPet>> findAllVirtualPets() {
        List<VirtualPet> virtualPets = virtualPetService.getAllVirtualPets();
        return ResponseEntity.ok(virtualPets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VirtualPet> getVirtualPetById(@PathVariable Long id) {
        VirtualPet virtualPet = virtualPetService.getVirtualPetById(id);
        if (virtualPet == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(virtualPet);
    }

    @PostMapping
    public ResponseEntity<VirtualPet> createVirtualPet(@RequestBody VirtualPet virtualPet) {
        VirtualPet createVirtualPet = virtualPetService.createVirtualPet(virtualPet);
        return new ResponseEntity<> (createVirtualPet, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVirtualPet(@PathVariable Long id) {
        boolean isDeleted = virtualPetService.deleteVirtualPet(id);
        if (!isDeleted) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.noContent().build();
    }

}
