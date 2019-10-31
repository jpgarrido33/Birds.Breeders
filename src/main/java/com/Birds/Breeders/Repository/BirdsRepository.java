package com.Birds.Breeders.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Birds.Breeders.Model.Birds;
@Repository
public interface BirdsRepository extends JpaRepository<Birds, Long> {

	
	//@Query(value="SELECT mi FROM Birds mi Group by mi.specimen", nativeQuery=true)
	@Query(value="SELECT * FROM birdsbreedersbd.birds group by specimen_id" , nativeQuery=true)
	public Page<Birds> pageBirdsOrderBySpecimen(Pageable pageable);
}
