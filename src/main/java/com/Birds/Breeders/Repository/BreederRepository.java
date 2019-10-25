package com.Birds.Breeders.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Birds.Breeders.Model.Breeder;

public interface BreederRepository extends JpaRepository<Breeder, Long> {

}
