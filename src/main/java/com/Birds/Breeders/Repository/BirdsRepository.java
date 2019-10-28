package com.Birds.Breeders.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Birds.Breeders.Model.Birds;
@Repository
public interface BirdsRepository extends JpaRepository<Birds, Long> {

}
