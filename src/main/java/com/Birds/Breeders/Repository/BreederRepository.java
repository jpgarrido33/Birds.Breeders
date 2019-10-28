package com.Birds.Breeders.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Birds.Breeders.Model.Breeder;
@Repository
public interface BreederRepository extends JpaRepository<Breeder, Long> {

}
