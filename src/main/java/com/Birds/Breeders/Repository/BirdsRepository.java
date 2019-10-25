package com.Birds.Breeders.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Birds.Breeders.Model.Birds;

public interface BirdsRepository extends JpaRepository<Birds, Long> {

}
