package com.Birds.Breeders.Mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.Birds.Breeders.DTO.BreederDTO;
import com.Birds.Breeders.Model.Breeder;

@Component
public class MapperSrvBreederImpl implements MapperService<BreederDTO, Breeder> {

	@Override
	public BreederDTO mapToDto(Breeder entity) {
		
		final BreederDTO breederDto=new BreederDTO();
		
		if(Optional.ofNullable(entity).isPresent()) {
		breederDto.setId(entity.getId());
		breederDto.setNombre(entity.getNombre());
		breederDto.setApellidos(entity.getApellidos());
		breederDto.setfNac(entity.getFnac().toString());
		breederDto.setNumCriador(entity.getNumCriador());
		breederDto.setSexo(entity.getSexo());
		
		}
		
		return breederDto;
	}

	@Override
	public Breeder mapToEntity(BreederDTO dto) {
		
		final Breeder breeder= new Breeder();
		
		if( Optional.ofNullable(dto).isPresent()) {
			breeder.setId(dto.getId());
			breeder.setNombre(dto.getNombre());
			breeder.setApellidos(dto.getApellidos());
			breeder.setFnac(LocalDate.parse(dto.getfNac(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			breeder.setNumCriador(dto.getNumCriador());
			breeder.setSexo(dto.getSexo());
		}
		
		return breeder;
	}

	@Override
	public List<BreederDTO> mapListToDto(List<Breeder> listEntity) {
		final List<BreederDTO> listBreederDto=new ArrayList<>();
		 listEntity.forEach((b)->{
			final BreederDTO breederDto= mapToDto(b);
			listBreederDto.add(breederDto);
		});
		return listBreederDto;
	}

	@Override
	public Page<BreederDTO> mapPageToDto(Page<Breeder> pageEntity) {
		
		return pageEntity.map(b-> mapToDto(b));
	}
	

}
