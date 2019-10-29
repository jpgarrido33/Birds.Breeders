package com.Birds.Breeders.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.Birds.Breeders.DTO.BirdsDTO;
import com.Birds.Breeders.Mapper.MapperService;
import com.Birds.Breeders.Model.Birds;
import com.Birds.Breeders.Model.Breeder;
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
	@Autowired
	private BirdsService birdsSRV;

	@Override
	public Birds createBirds(BirdsDTO birdsDto) {


			return birdsRepository.save(mapperBirds.mapToEntity(birdsDto));
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

	@Override
	public Birds createRelationBB(Long idbird, Long idbreeder) {
		
		Birds birds= birdsSRV.getBirds(idbird);
		Breeder breeder=breederSRV.getBreeder(idbreeder);
		
		birds.setBreeder(breeder);
		List<Birds> listbirds=new ArrayList<Birds>();
		listbirds.add(birds);
		
		return birdsRepository.save(birds);
	}

}
