package com.wcci.virtualPetAPI.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcci.virtualPetAPI.entity.VirtualPet;
import com.wcci.virtualPetAPI.repository.VirtualPetRepository;

@Service
public class VirtualPetService {

    @Autowired
    private VirtualPetRepository virtualPetRepository;

    public VirtualPet createVirtualPet(VirtualPet virtualPet) {
        return virtualPetRepository.save(virtualPet);
    }

    public List<VirtualPet> getAllVirtualPets() {
        return virtualPetRepository.findAll();
    }

    public VirtualPet getVirtualPetById(Long id) {
        return virtualPetRepository.findById(id).orElse(null);
    }

    public void updateVirtualPet(VirtualPet updatedVirtualPet) {
        virtualPetRepository.save(updatedVirtualPet);
    }

    public boolean deleteVirtualPet(Long id) {
        if (!virtualPetRepository.existsById(id)) return false;

        virtualPetRepository.deleteById(id);
        return true;
    }

}
