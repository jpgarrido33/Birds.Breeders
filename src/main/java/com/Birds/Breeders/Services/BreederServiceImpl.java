package com.Birds.Breeders.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Birds.Breeders.DTO.BreederDTO;
import com.Birds.Breeders.Mapper.MapperService;
import com.Birds.Breeders.Model.Breeder;
import com.Birds.Breeders.Repository.BreederRepository;

@Service
public class BreederServiceImpl implements BreederService {
	
	@Autowired
	private MapperService<BreederDTO, Breeder> mapperBreeder;
	@Autowired
	private BreederRepository breederRepository;

	@Override
	public Breeder createBreeder(BreederDTO breederDto) {

		return breederRepository.save(mapperBreeder.mapToEntity(breederDto));
	}

	@Override
	public Breeder getBreeder(Long id) {
		
		return breederRepository.findById(id).get();
	}

	@Override
	public Page<Breeder> getListBreeder(Pageable pageable) {
		
		return breederRepository.findAll(pageable);
	}

	@Override
	public void deleteBreeder(Long id) {
		breederRepository.delete(this.getBreeder(id));
		
	}

	@Override
	public Breeder updateBreeder(Long id, BreederDTO breederDto) {
	
		Breeder breeder= this.getBreeder(id);
		
		breeder.setNombre(breederDto.getNombre());
		breeder.setApellidos(breederDto.getApellidos());
		breeder.setFnac(LocalDate.parse(breederDto.getfNac(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		breeder.setNumCriador(breederDto.getNumCriador());
		breeder.setSexo(breederDto.getSexo());
		
		return breederRepository.save(breeder);
	}

	
}
