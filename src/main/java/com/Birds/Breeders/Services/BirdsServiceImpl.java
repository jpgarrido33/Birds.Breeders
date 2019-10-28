package com.Birds.Breeders.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.Birds.Breeders.DTO.BirdsDTO;
import com.Birds.Breeders.Mapper.MapperService;
import com.Birds.Breeders.Model.Birds;
import com.Birds.Breeders.Repository.BirdsRepository;
import com.Birds.Breeders.Repository.BreederRepository;

@Service
public class BirdsServiceImpl implements BirdsService {
	
	@Autowired
	private MapperService<BirdsDTO, Birds> mapperBirds;
	@Autowired 
	private BirdsRepository birdsRepository;
	@Autowired
	private BreederService breederSRV;

	@Override
	public Birds createBirds(Long idBreeder,BirdsDTO birdsDto) {

			final Birds birds=mapperBirds.mapToEntity(birdsDto);
			birds.setBreeder(birdsDto.getBreeder());
			birds.setColor(birdsDto.getColor());
			birds.setEspecie(birdsDto.getEspecie());
			birds.setfNac(LocalDate.parse(birdsDto.getfNac(),DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			birds.setNomCientif(birds.getNomCientif());
			birds.setNumAnilla(birdsDto.getNumAnilla());
			birds.setSexo(birdsDto.getSexo());
			birds.setBreeder(breederSRV.getBreeder(idBreeder));
			
			return birdsRepository.save(birds);
			
			//final Optional<Birds> birds= Optional.ofNullable(mapperBirds.mapToEntity(birdsDto));
			//birds.get().setfNac(LocalDate.parse(birdsDto.getfNac(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			//return birdsRepository.save(birds.get());
	}

	@Override
	public Birds getBirds(long id) {
		
		return birdsRepository.findById(id).orElseThrow(null);
	}

	@Override
	public Page<Birds> getListBirds(Pageable pageable) {
	
			return birdsRepository.findAll(pageable);
		
	}

	@Override
	public void deleteBirds(long id) {
		
		birdsRepository.delete(Optional.ofNullable(this.getBirds(id)).orElseThrow(null));
		
		
	}

	@Override
	public Birds updateBirds(long id, BirdsDTO birdsDto) {
		
		Birds birds=this.getBirds(id);
		birds.setBreeder(birdsDto.getBreeder());
		birds.setColor(birdsDto.getColor());
		birds.setEspecie(birdsDto.getEspecie());
		birds.setfNac(LocalDate.parse(birdsDto.getfNac(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		birds.setNomCientif(birds.getNomCientif());
		birds.setNumAnilla(birdsDto.getNumAnilla());
		birds.setSexo(birdsDto.getSexo());
		
		
		return birdsRepository.save(birds);
	}

}
