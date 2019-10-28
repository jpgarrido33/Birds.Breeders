package com.Birds.Breeders.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Birds.Breeders.DTO.BirdsDTO;
import com.Birds.Breeders.Model.Birds;

public interface BirdsService {
	
	Birds createBirds (Long idBreeder, BirdsDTO  BirdsDto);
	
	Birds getBirds (long id);

	Page<Birds> getListBirds (Pageable pageable);
	
	void deleteBirds (long id);
	
	Birds updateBirds (long id, BirdsDTO birdsDto );
}
