package com.Birds.Breeders.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import com.Birds.Breeders.DTO.SpecimenDTO;
import com.Birds.Breeders.Model.Specimen;

public class MapperSrvSpecimenImpl implements MapperService<SpecimenDTO, Specimen > {

	@Override
	public SpecimenDTO mapToDto(Specimen entity) {
		final SpecimenDTO specimenDto= new SpecimenDTO();
		if( Optional.ofNullable(entity).isPresent()) {
			specimenDto.setId(entity.getId());
			specimenDto.setNombreespecie(entity.getNombreespecie());
		}
		
		return specimenDto;
	}

	@Override
	public Specimen mapToEntity(SpecimenDTO dto) {
		final Specimen specimen= new Specimen();
		if( Optional.ofNullable(dto).isPresent()) {
			specimen.setId(dto.getId());
			specimen.setNombreespecie(dto.getNombreespecie());
		}
		return specimen;
	}

	@Override
	public List<SpecimenDTO> mapListToDto(List<Specimen> listEntity) {
		final List<SpecimenDTO> listSpecimenDto=new ArrayList<>();
		 listEntity.forEach((b)->{
			final SpecimenDTO specimenDto= mapToDto(b);
			listSpecimenDto.add(specimenDto);
		});
		return listSpecimenDto;
	}

	@Override
	public Page<SpecimenDTO> mapPageToDto(Page<Specimen> pageEntity) {

		return pageEntity.map(b-> mapToDto(b));
	}



}
