package hu.bandur.mvc.dao;

import org.springframework.data.repository.CrudRepository;

import hu.bandur.mvc.data.entities.Position;

public interface PositionDAO extends CrudRepository<Position, Integer> {

}
