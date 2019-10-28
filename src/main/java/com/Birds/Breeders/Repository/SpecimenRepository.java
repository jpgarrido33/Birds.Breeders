package com.Birds.Breeders.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Birds.Breeders.Model.Specimen;
@Repository
public interface SpecimenRepository extends JpaRepository<Specimen, Long> {

}
