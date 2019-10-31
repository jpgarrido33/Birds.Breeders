package com.Birds.Breeders.Controller;


import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Birds.Breeders.DTO.BirdsDTO;
import com.Birds.Breeders.DTO.SpecimenDTO;
import com.Birds.Breeders.Exception.BirdNotFoundException;
import com.Birds.Breeders.Exception.BirdsDuplicateException;
import com.Birds.Breeders.Exception.BreederNotfoundException;
import com.Birds.Breeders.Exception.SpecimenNotFoundException;
import com.Birds.Breeders.Mapper.MapperService;
import com.Birds.Breeders.Model.Birds;
import com.Birds.Breeders.Services.BirdsService;

@RestController
@RequestMapping ("/birds")
public class BirdsController {
	
	@Autowired
	private MapperService<BirdsDTO, Birds> mapper;
	@Autowired
	private BirdsService BirdsSRV;
	
	@GetMapping
	public Page<BirdsDTO> getPageBirdsDto(@PageableDefault(page = 0, value = 25) Pageable pageable){
		
		return mapper.mapPageToDto(BirdsSRV.getListBirds(pageable));
	}
	
	@GetMapping("/{id}")
	public BirdsDTO getBirdsId(@PathVariable ("id") Long id) throws BirdNotFoundException {
		return mapper.mapToDto(BirdsSRV.getBirds(id));
		
	}
	
	@PostMapping
	public BirdsDTO createBirdsDTO(@Valid @RequestBody BirdsDTO birdsDto) throws BirdsDuplicateException {
		
			return mapper.mapToDto(BirdsSRV.createBirds(birdsDto));
		
	}
	
	@PutMapping ("/{id}")
	public BirdsDTO updateBirds(@Valid @PathVariable("id") Long id, @RequestBody BirdsDTO birdsDto ) throws BirdNotFoundException {
		
		return mapper.mapToDto(BirdsSRV.updateBirds(id, birdsDto));
		
	}
	
	@PutMapping ("/{idBird}/breeder/{idBreeder}")
	public BirdsDTO CreateRelationBirdsBreeder(@PathVariable("idBird") Long idbird,@PathVariable("idBreeder") Long idbreeder) throws BirdNotFoundException, BreederNotfoundException {
		
		return mapper.mapToDto(BirdsSRV.createRelationBB(idbird, idbreeder));
	}
	
	@PutMapping("/{idBirds}/specimen/{idSpecimen}")
	public BirdsDTO createRelationspecimenBirds(@PathVariable ("idBirds") Long idbirds, @PathVariable ("idSpecimen") Long idSpecimen) throws BirdNotFoundException, SpecimenNotFoundException{
		
		return mapper.mapToDto(BirdsSRV.createrelationBS(idbirds,idSpecimen));
	}
	

	@DeleteMapping("/{id}")
	public void deleteBirds(@PathVariable("id") Long id) throws BirdNotFoundException {
		BirdsSRV.deleteBirds(id);
	}
	
	@GetMapping("/LisBirds") // nuevo, revisar
	public Page<BirdsDTO> getPagesBirdsDtoOrderBySpecimen(@PageableDefault(page = 0, value = 25) Pageable pageable){
		
		return mapper.mapPageToDto(BirdsSRV.getPageBirdsOrderBySpecimen(pageable)); 
	}
	
}
