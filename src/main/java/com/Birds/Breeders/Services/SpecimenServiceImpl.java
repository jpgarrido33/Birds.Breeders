package com.Birds.Breeders.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Birds.Breeders.DTO.SpecimenDTO;
import com.Birds.Breeders.Exception.SpecimenNotFoundException;
import com.Birds.Breeders.Mapper.MapperService;
import com.Birds.Breeders.Model.Birds;
import com.Birds.Breeders.Model.Specimen;
import com.Birds.Breeders.Repository.SpecimenRepository;



@Service
public class SpecimenServiceImpl implements SpecimenService {
	
	@Autowired
	private MapperService<SpecimenDTO, Specimen> mapperSpecimen;
	@Autowired
	private SpecimenRepository specimentRepository;
	@Autowired
	private SpecimenService specimenSRV;
	@Autowired
	private BirdsService birdsSRV;
	
	
	@Override
	public Specimen createSpecimen(SpecimenDTO specimenDto) {
		
		final Optional <Specimen> specimen= Optional.ofNullable(mapperSpecimen.mapToEntity(specimenDto));
		return specimentRepository.save(specimen.get()) ;
	}

	@Override
	public Specimen getSpecimen(Long id) throws SpecimenNotFoundException {
		
		
		return specimentRepository.findById(id).orElseThrow(SpecimenNotFoundException:: new);
	}

	@Override
	public Page<Specimen> listspecimen(Pageable pageable) {
		
		return specimentRepository.findAll(pageable);
	}

	@Override
	public void deleteSpecimen(Long id) throws  SpecimenNotFoundException {
		
		specimentRepository.delete(Optional.ofNullable(this.getSpecimen(id)).orElseThrow(SpecimenNotFoundException:: new));
		
	}

	@Override
	public Specimen updateSpecimen(Long id, SpecimenDTO specimendto) throws SpecimenNotFoundException {
		
		Specimen specimen=this.getSpecimen(id);
		specimen.setNombreespecie(specimendto.getNombreespecie());
		
		return specimentRepository.save(specimen);
	}

}
