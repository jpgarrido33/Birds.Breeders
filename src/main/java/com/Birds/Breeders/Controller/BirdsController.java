package com.Birds.Breeders.Controller;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
//	@GetMapping
//	public Page<BirdsDTO> getPageBirdsDto(@PageableDefault(page = 0, value = 10) Pageable pageable){
//		
//		return mapper.mapPageToDto(BirdsSRV);
//	}

}
