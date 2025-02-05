package com.wcci.virtualpetsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualpetsapi.entity.VirtualPet;

@Repository
public interface VirtualPetRepository extends JpaRepository<VirtualPet, Long> {

}
