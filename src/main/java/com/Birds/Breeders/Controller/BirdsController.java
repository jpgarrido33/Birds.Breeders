package com.Birds.Breeders.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Birds.Breeders.DTO.BirdsDTO;
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
	public BirdsDTO getBirdsId(@PathVariable ("id") Long id) {
		return mapper.mapToDto(BirdsSRV.getBirds(id));
		
	}
	
	@PostMapping
	public BirdsDTO createBirdsDTO(@RequestBody BirdsDTO birdsDto) {
		return mapper.mapToDto(BirdsSRV.createBirds(birdsDto));
		
	}
	
	@PutMapping ("/{id}")
	public BirdsDTO updateBirds(@PathVariable("id") Long id, @RequestBody BirdsDTO birdsDto ) {
		
		return mapper.mapToDto(BirdsSRV.updateBirds(id, birdsDto));
		
	}

	@DeleteMapping("/{id}")
	public void deleteBirds(@PathVariable("id") Long id) {
		BirdsSRV.deleteBirds(id);
	}
}
