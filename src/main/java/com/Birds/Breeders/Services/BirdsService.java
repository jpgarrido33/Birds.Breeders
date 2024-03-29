package com.Birds.Breeders.Services;

import java.sql.SQLException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Birds.Breeders.DTO.BirdsDTO;
import com.Birds.Breeders.Exception.BirdNotFoundException;
import com.Birds.Breeders.Exception.BirdsDuplicateException;
import com.Birds.Breeders.Exception.BreederNotfoundException;
import com.Birds.Breeders.Exception.SpecimenNotFoundException;
import com.Birds.Breeders.Model.Birds;

public interface BirdsService {
	
	Birds createBirds ( BirdsDTO  BirdsDto) throws BirdsDuplicateException ;
	
	Birds getBirds (long id) throws BirdNotFoundException;

	Page<Birds> getListBirds (Pageable pageable);
	
	void deleteBirds (long id) throws BirdNotFoundException;
	
	Birds updateBirds (long id, BirdsDTO birdsDto ) throws BirdNotFoundException;

	Birds createRelationBB(Long idbird, Long idbreeder) throws BirdNotFoundException, BreederNotfoundException;

	Birds createrelationBS(Long idBirds, Long idSpecimen) throws BirdNotFoundException, SpecimenNotFoundException;

	Page<Birds> getPageBirdsOrderBySpecimen(Pageable pageable);

}
