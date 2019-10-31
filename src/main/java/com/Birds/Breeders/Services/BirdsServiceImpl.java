package com.Birds.Breeders.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import com.Birds.Breeders.DTO.BirdsDTO;
import com.Birds.Breeders.Exception.BirdNotFoundException;
import com.Birds.Breeders.Exception.BirdsDuplicateException;
import com.Birds.Breeders.Exception.BreederNotfoundException;
import com.Birds.Breeders.Exception.SpecimenNotFoundException;
import com.Birds.Breeders.Mapper.MapperService;
import com.Birds.Breeders.Model.Birds;
import com.Birds.Breeders.Model.Breeder;
import com.Birds.Breeders.Model.Specimen;
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
	@Autowired
	private SpecimenService specimenSRV;

	@Override
	public Birds createBirds(BirdsDTO birdsDto) throws BirdsDuplicateException    {
		
		  return  birdsRepository.save(Optional.ofNullable(mapperBirds.mapToEntity(birdsDto)).orElseThrow(BirdsDuplicateException::new));
	}

	@Override
	public Birds getBirds(long id) throws BirdNotFoundException {
		
		return birdsRepository.findById(id).orElseThrow(BirdNotFoundException::new);
	}

	@Override
	public Page<Birds> getListBirds(Pageable pageable ) {
	
			return birdsRepository.findAll(pageable);
		
	}

	@Override
	public void deleteBirds(long id) throws BirdNotFoundException {
		
		birdsRepository.delete(Optional.ofNullable(this.getBirds(id)).orElseThrow(BirdNotFoundException:: new));
		
	}

	@Override
	public Birds updateBirds(long id, BirdsDTO birdsDto) throws BirdNotFoundException {
		
		Birds birds=this.getBirds(id);
		birds.setColor(birdsDto.getColor());
		birds.setEspecie(birdsDto.getEspecie());
		birds.setfNac(LocalDate.parse(birdsDto.getfNac(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		birds.setNomCientif(birdsDto.getNomCientif());
		birds.setNumAnilla(birdsDto.getNumAnilla());
		birds.setSexo(birdsDto.getSexo());
		
		
		return birdsRepository.save(birds);
	}

	@Override
	public Birds createRelationBB(Long idbird, Long idbreeder) throws BirdNotFoundException,BreederNotfoundException {
		
		
		Birds birds= birdsSRV.getBirds(idbird);
		Breeder breeder=breederSRV.getBreeder(idbreeder);
		
		if(birds==null) {
			new BirdNotFoundException();
		}
		else if(breeder==null) {
			new BreederNotfoundException();
		}
		
		birds.setBreeder(breeder);
		List<Birds> listbirds=new ArrayList<Birds>();
		listbirds.add(birds);
		
		return birdsRepository.save(birds);
	}

	@Override
	public Birds createrelationBS(Long idbirds, Long idSpecimen) throws BirdNotFoundException, SpecimenNotFoundException {

		Birds birds=birdsSRV.getBirds(idbirds);
		Specimen specimen= specimenSRV.getSpecimen(idSpecimen);
		
		if(birds==null) {
			new BirdNotFoundException();
		}
		
		birds.setSpemcimen(specimen);
		List<Birds> listbirds=new ArrayList<Birds>();
		listbirds.add(birds);
		
		return birdsRepository.save(birds);
	}

	@Override
	public Page<Birds> getPageBirdsOrderBySpecimen(Pageable pageable) {
		// TODO Auto-generated method stub
		return birdsRepository.pageBirdsOrderBySpecimen(pageable);
	}

}
