package com.Birds.Breeders.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Birds.Breeders.DTO.BreederDTO;
import com.Birds.Breeders.Mapper.MapperService;
import com.Birds.Breeders.Model.Breeder;
import com.Birds.Breeders.Services.BreederService;

@RestController
@RequestMapping ("/breeder")
public class BreederController {
	
	@Autowired
	private MapperService<BreederDTO, Breeder> mapperBreeder;
	@Autowired
	private BreederService breederSRV;
	
	@GetMapping
	public Page<BreederDTO> getPageBreeder(@PageableDefault(page = 0, value = 25) Pageable pageable){
		
		return mapperBreeder.mapPageToDto(breederSRV.getListBreeder(pageable));
	}
	
	@GetMapping("/{id}")
	public BreederDTO getBreederId(@PathVariable ("id") Long id) {
		return mapperBreeder.mapToDto(breederSRV.getBreeder(id));
	}
	
	@PostMapping
	public BreederDTO createBreeder(@RequestBody BreederDTO breederDto) {
		
		return mapperBreeder.mapToDto(breederSRV.createBreeder(breederDto)) ;
	}
	
	@PutMapping ("/{id}")
	public BreederDTO updateBreeder(@PathVariable ("id") Long id, @RequestBody BreederDTO breederDto){
		
		return mapperBreeder.mapToDto(breederSRV.updateBreeder(id, breederDto));
		
	}

}
