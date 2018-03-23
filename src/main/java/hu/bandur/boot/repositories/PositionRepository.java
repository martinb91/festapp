package hu.bandur.boot.repositories;

import hu.bandur.boot.entities.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Integer> {

}
