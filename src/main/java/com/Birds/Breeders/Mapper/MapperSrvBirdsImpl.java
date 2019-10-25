package com.Birds.Breeders.Mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.Birds.Breeders.DTO.BirdsDTO;
import com.Birds.Breeders.DTO.BreederDTO;
import com.Birds.Breeders.Model.Birds;
import com.Birds.Breeders.Model.Breeder;


//

@Component
public class MapperSrvBirdsImpl implements MapperService<BirdsDTO, Birds> {

	@Autowired 
	private MapperService<BreederDTO, Breeder> MapperBreeder;
	
	@Override
	public BirdsDTO mapToDto(Birds entity) {
		final BirdsDTO birdsDto=new BirdsDTO();
		if(Optional.ofNullable(entity).isPresent()) {
			
			birdsDto.setId(entity.getId());
			birdsDto.setColor(entity.getColor());
			birdsDto.setEspecie(entity.getEspecie());
			birdsDto.setfNac(entity.getfNac().toString());
			birdsDto.setNomCientif(entity.getNomCientif());
			birdsDto.setNumAnilla(entity.getNumAnilla());
			birdsDto.setSexo(entity.getSexo());
			birdsDto.setBreeder(entity.getBreeder());
			
		}
				
		return birdsDto;
	}

	@Override
	public Birds mapToEntity(BirdsDTO dto) {
		final Birds birds=new Birds();
		if(Optional.ofNullable(dto).isPresent()) {
			birds.setId(dto.getId());
			birds.setColor(dto.getColor());
			birds.setEspecie(dto.getEspecie());
			birds.setfNac(LocalDate.parse(dto.getfNac(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			birds.setNomCientif(dto.getNomCientif());
			birds.setNumAnilla(dto.getNumAnilla());
			birds.setSexo(dto.getSexo());
			birds.setBreeder(dto.getBreeder());
			
		}
		
		return birds;
	}

	@Override
	public List<BirdsDTO> mapListToDto(List<Birds> listEntity) {

		final List<BirdsDTO> listBirdsDto=new ArrayList<>();
		 listEntity.forEach((b)->{
			final BirdsDTO birdsDto= mapToDto(b);
			listBirdsDto.add(birdsDto);
		});
		return listBirdsDto;
	}

	@Override
	public Page<BirdsDTO> mapPageToDto(Page<Birds> pageEntity) {
		
		
		return pageEntity.map(b-> mapToDto(b));
	}



	



}
