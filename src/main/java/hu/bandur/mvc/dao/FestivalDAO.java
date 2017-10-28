package hu.bandur.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.bandur.mvc.data.entities.Festival;


public interface FestivalDAO extends JpaRepository<Festival, Long>{

}
