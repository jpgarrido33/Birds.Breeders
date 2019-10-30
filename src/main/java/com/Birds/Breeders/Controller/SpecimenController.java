package com.Birds.Breeders.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Birds.Breeders.DTO.SpecimenDTO;
import com.Birds.Breeders.Mapper.MapperService;
import com.Birds.Breeders.Model.Specimen;
import com.Birds.Breeders.Services.SpecimenService;

@RestController
@RequestMapping("/specimen")
public class SpecimenController {
	
	@Autowired
	private MapperService <SpecimenDTO, Specimen> mapperSpecimen;
	
	@Autowired
	private SpecimenService specimenSRV;
	
	@GetMapping
	public  Page<SpecimenDTO> getPageSpecimen(@PageableDefault(page = 0, value = 25) Pageable pageable){
		
		return mapperSpecimen.mapPageToDto(specimenSRV.listspecimen(pageable));
		
	}
	
	@GetMapping ("/{id}")
	public SpecimenDTO getSpecimen(@PathVariable ("id") Long id) {
		
		return mapperSpecimen.mapToDto(specimenSRV.getSpecimen(id));
		
	}
	
	@PostMapping
	public SpecimenDTO createSpecimen( @RequestBody SpecimenDTO specimenDto) {
		
		return mapperSpecimen.mapToDto(specimenSRV.createSpecimen(specimenDto));
	}
	

}
