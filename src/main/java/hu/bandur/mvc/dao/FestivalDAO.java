package hu.bandur.mvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.bandur.mvc.data.entities.Festival;


public interface FestivalDAO extends CrudRepository<Festival, Integer>{
	List<Festival> findAll();

}
