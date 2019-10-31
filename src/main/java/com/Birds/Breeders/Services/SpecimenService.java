package com.Birds.Breeders.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Birds.Breeders.DTO.SpecimenDTO;
import com.Birds.Breeders.Exception.SpecimenNotFoundException;
import com.Birds.Breeders.Model.Specimen;

public interface SpecimenService {

	Specimen createSpecimen(SpecimenDTO specimenDto);
	
	Specimen getSpecimen (Long id) throws SpecimenNotFoundException;
	
	Page <Specimen> listspecimen(Pageable pageable);
	
	void  deleteSpecimen (Long id) throws SpecimenNotFoundException;
	
	Specimen updateSpecimen ( Long id,SpecimenDTO specimendto) throws SpecimenNotFoundException;

	
}
