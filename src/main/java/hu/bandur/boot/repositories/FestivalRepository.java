package hu.bandur.boot.repositories;

import hu.bandur.boot.entities.Festival;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FestivalRepository extends CrudRepository<Festival, Integer>{

 List<Festival> findAll();
 }
