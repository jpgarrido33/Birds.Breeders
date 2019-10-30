package com.Birds.Breeders.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.Birds.Breeders.DTO.BreederDTO;
import com.Birds.Breeders.Exception.BreederNotfoundException;
import com.Birds.Breeders.Model.Breeder;

public interface BreederService {

	Breeder createBreeder (BreederDTO breederDto);

	Breeder getBreeder(Long id) throws BreederNotfoundException;
	
	Page<Breeder> getListBreeder(Pageable pageable);
	
	void deleteBreeder(Long id) throws BreederNotfoundException;
	
	Breeder updateBreeder(Long id, BreederDTO breederDto) throws BreederNotfoundException;
	
}

