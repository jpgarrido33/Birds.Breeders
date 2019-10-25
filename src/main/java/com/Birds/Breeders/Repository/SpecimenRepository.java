package com.Birds.Breeders.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Birds.Breeders.Model.Specimen;

public interface SpecimenRepository extends JpaRepository<Specimen, Long> {

}
