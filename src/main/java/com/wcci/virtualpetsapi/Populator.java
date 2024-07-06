package com.wcci.virtualpetsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcci.virtualpetsapi.entity.VirtualPet;
import com.wcci.virtualpetsapi.repository.VirtualPetRepository;

@Component
public class Populator implements CommandLineRunner{

    @Autowired
    private VirtualPetRepository virtualPetRepository;

    @Override
    public void run(String... args) throws Exception {
        virtualPetRepository.deleteAll();

        VirtualPet sam = new VirtualPet("Sam", "Sam is a cat.");
        VirtualPet sally = new VirtualPet("Sally", "Sally is a dog.");
        VirtualPet spot = new VirtualPet("Spot", "Spot is a squirrel.");
        VirtualPet susan = new VirtualPet("Susan", "Susan is an elephant.");
        VirtualPet sebastian = new VirtualPet("Sebastian", "Sebastian is a bear.");

        virtualPetRepository.save(sam);
        virtualPetRepository.save(sally);
        virtualPetRepository.save(spot);
        virtualPetRepository.save(susan);
        virtualPetRepository.save(sebastian);
    }


}
