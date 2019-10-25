package com.Birds.Breeders.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
			//birdsDto.setBreader(MapperBreeder.mapToDto(entity.getBreeder()));
			
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
			
		}
		
		return null;
	}

	@Override
	public List<BirdsDTO> mapListToDto(List<Birds> listEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BirdsDTO> mapPageToDto(Page<Birds> pageEntity) {
		// TODO Auto-generated method stub
		return null;
	}



	



}
