package com.Birds.Breeders.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.Birds.Breeders.DTO.BreederDTO;
import com.Birds.Breeders.Model.Breeder;

public interface BreederService {

	Breeder createBreeder (BreederDTO breederDto);

	Breeder getBreeder(Long id);
	
	Page<Breeder> getListBreeder(Pageable pageable);
	
	void deleteBreeder(Long id);
	
	Breeder updateBreeder(Long id, BreederDTO breederDto);
	
}

