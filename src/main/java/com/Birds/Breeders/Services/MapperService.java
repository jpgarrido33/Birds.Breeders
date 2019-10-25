package com.Birds.Breeders.Services;

import java.util.List;

import org.springframework.data.domain.Page;

public interface MapperService<D,E> {

	D mapToDto (E entity);
	
	E mapToEntity (D dto) ;

	List<D> mapListToDto(List<E> listEntity);

	Page<D> mapPageToDto(Page<E> pageEntity);
}
